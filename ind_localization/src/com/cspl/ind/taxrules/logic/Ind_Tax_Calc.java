package com.cspl.ind.taxrules.logic;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;

import javax.sql.RowSet;

import org.adempiere.base.IColumnCallout;
import org.adempiere.model.GridTabWrapper;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.GridTabVO;
import org.compiere.model.GridWindow;
import org.compiere.model.MClientInfo;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Trx;

//import com.cspl.ind.table.extensions.*;

import com.cspl.ind.tables.*;
//import com.cspl.ind.taxrules.callouts.Ind_Invoice_Callout;
/*Created by Satish Vijayan
 * Date: 25th September 2018
 * Following instructions by Jan Thielman https://www.youtube.com/watch?v=twC6Dy8R5g4
 * Used to pick the correct gst rate based on:
 * a. Type of Business Partner (RD - Regd Dealer, URD - Unregistered , ECD- eCommerce, EXD - exempted dealer, CD - Composite dealer)
 * b. Type of Tax (Withholding Tax (used in Payments), GST - used in Invoices)
 * c. HSN Code - based on Product m_product->ind_hsn_sac_codes_id & m_product->ind_tax_category_id
 * d. Location - local or interstate
 * Above types have been defined in ind_tax_entity_type
 * Based on A, B, C & D- the value of c_tax_id is set from the table ind_client_tax_rules;

 * */
public class Ind_Tax_Calc 
{
	private static String sGetTaxDetails 					= "get_Ind_hsn_tax_details";
	private static String sColumnName_Tax_ID 				= "ret_c_Tax_id";
	private static String sColumnName_Tax_Category_ID 		= "ret_Tax_category_id";
	private static String sColumnName_Buyer_entity_Type_ID 	= "ret_ind_buyer_tax_entity_type_id";
	private static String sColumnName_Seller_entity_Type_ID	= "ret_ind_seller_tax_entity_type_id";
	private static String sColumnName_GST_Rate 				= "ret_gst_rate";
	private static String sColumnName_Cess_Rate 			= "ret_cess_rate";
	private static String sColumnName_isITC 				= "ret_isitc";
	private static String sColumnName_isLocal 				= "ret_islocal";
	//private static String sTaxCategory_GST 					= "GST";
	//private static String staxStandard						= "Standard";
	// create a Tax_entity_category class to get 
	// tax_entity_ID for Composite Dealer and Un registered dealer..
	// get entity tax type and location details for Buyer and seller - 
	private MInvoice mParm_Inv=null;
	private int iClient_ID;
	private Timestamp InvoiceDate;
	private int iBPartner_ID;				// = mParm_Inv.getC_BPartner_ID();
	private Properties ctx;
	private MInd_Statutory_Org MStatLoc ;			//= new (ctx, mParm_Inv.getAD_Org_ID());
	private MInd_Statutory_BPartner mBPStatLoc ;	//= new (ctx, iBPartner_ID);	
	private int iMyLocation_ID ;					//= MStatLoc.getC_Location_ID();;
	private int iBPartnerLocation_ID;				// = mBPStatLoc.getC_Location_ID();;
	private int iMyEntityType_ID;					// =MStatLoc.getInd_Tax_Entity_Type_ID();
	private int iBPartnerEntity_Type_ID;				//=mBPStatLoc.getInd_Tax_Entity_Type_ID();
	private String sURD="";
	private String sBuyerEntityType="";
	private String sSellerEntityType="";		
	private String sTax_Category_ID_GST ;			//= Integer.toString((new MInd_Tax_Category(ctx, Ind_Invoice_Callout.sTaxCategory_GST)).getInd_Tax_Category_ID()); // confirm that its GST
	private MInd_Tax_Entity_Type MTaxEntLoc ;		//= new MInd_Tax_Entity_Type(ctx, iMyEntityType_ID, null);
	private String isSales ;						//= mParm_Inv.isSOTrx()?"Y":"N";
	private String sLOCAL="Y"; //, sITC="Y", sComposite="N";
	private GridTab mTab;
	private GridField mField;
	private int iWindow;
	private String sStandard_Tax_ID;
	//private int iTaxCategory_GST_ID;//						= (new MInd_Tax_Category(Env.getCtx(), sTaxCategory_GST)).getInd_Tax_Category_ID();

	CLogger log = CLogger.getCLogger(Ind_Tax_Calc.class);
	
	
	public Ind_Tax_Calc(Properties ctx, GridTab mLocTab, GridField mField) 
	{
		this(ctx, Extract_MInvoice(ctx, mLocTab, mField));
	}
	public Ind_Tax_Calc(Properties ctx, MInvoice mi)
	{
		setInd_Inv_Params(ctx, mi);
	}
	
	public boolean processInvoice(Properties ctx, MInvoice mi)
	{
		String sTax=null;
		boolean isOK=true;
			
		if(mParm_Inv==null)  setInd_Inv_Params (ctx, mi);
		
		for(MInvoiceLine mil : mParm_Inv.getLines())
		{
			sTax= processInvoiceLine(ctx, mil);
			if(sTax != null)
			{
				mil.setC_Tax_ID(Integer.parseInt(sTax));
				mil.saveEx(mParm_Inv.get_TrxName());
			}
			else isOK=false;
		}
		return isOK;
	}
	
	private static MInvoice Extract_MInvoice(Properties ctx, GridTab mLocTab, GridField mField)
	{
		MInvoice mi=null;
		int i=mLocTab.getCurrentRow();
		if(mLocTab.getTableName().equalsIgnoreCase(MInvoice.Table_Name))
		{
			mi=(MInvoice) mLocTab.getTableModel().getPO(i);
		}
		else
		{
			mi=(MInvoice) mLocTab.getParentTab().getTableModel().getPO(i);
		}
		return mi;
	}
	
	public String processInvoiceLine(Properties ctx, MInvoiceLine mil) 
	{
		if(mParm_Inv==null)  setInd_Inv_Params (ctx, mil.getParent());
		return  getGST_Tax_ID(mil)
						; // gets the tax ID
	}
	public String processInvoiceLine(Properties ctx, MInvoice mi, String Item, boolean isProduct) 
	{
		try
		{
			
			if(mParm_Inv==null)  setInd_Inv_Params (ctx, mi);
			return  getGST_Tax_ID(Item, isProduct); // gets the tax ID
		
			//sC_Tax_ID = (sC_Tax_ID==null? "0" : sC_Tax_ID);
		
		}  catch (SQLException e) 
		{
			log.saveError("Error in Ind_Tax_Calc.java-ProcessInvoiceLine-New Line ERROR:", e);
			//isOK=false;
			return null;
		}
	}
	
	
	
	private String getGST_Tax_ID(MInvoiceLine mil) //throws SQLException 
	{
		
		String item;
		boolean isProduct;
		
		if(mil.getM_Product_ID()!=0)
		{
			item = Integer.toString(mil.getM_Product_ID());
			isProduct=true;
		}
		else
		{
			item = Integer.toString(mil.getC_Charge_ID());
			isProduct=false;
		}
		try
		{
			return getGST_Tax_ID(item, isProduct);
		} catch (SQLException e) {
			log.saveError("Error in Ind_Tax_Calc.java-gstGST_Tax_ID ERROR:", e);
			return null;
		}
	}
		
	private String getGST_Tax_ID(String item, boolean isProduct)  throws SQLException
	{
		String sRS_TaxCat="", sRS_SellerTaxEntType="", sRS_BuyerTaxEntType="", sRS_isLocal="";
		ResultSet rs;


		try {
			
			rs = MInd_Tax_Rules_MV.GetTaxCursor(iClient_ID, 
					Integer.parseInt(item) 
					,isProduct? MInvoiceLine.COLUMNNAME_M_Product_ID:MInvoiceLine.COLUMNNAME_C_Charge_ID 
					,MInd_Tax_Rules_MV.sTaxCategory_GST 
					,!isProduct, 
					InvoiceDate);
			while (rs.next())
			{
				//String sRS_TaxCat="", sRS_SellerTaxEntType="", sRS_BuyerTaxEntType="", sRS_isLocal=""; list of variables defined for processing resultset
				
				sRS_TaxCat=rs.getString(sColumnName_Tax_Category_ID);
				sRS_SellerTaxEntType = rs.getString(Ind_Tax_Calc.sColumnName_Seller_entity_Type_ID);
				sRS_BuyerTaxEntType = rs.getString(Ind_Tax_Calc.sColumnName_Buyer_entity_Type_ID);
				sRS_isLocal=rs.getString(Ind_Tax_Calc.sColumnName_isLocal);
				
								
				if( sTax_Category_ID_GST.equalsIgnoreCase(sRS_TaxCat) ) //FOR GST ONLY
				{
					if(
							(sSellerEntityType).equalsIgnoreCase( sRS_SellerTaxEntType )
							&& (sBuyerEntityType).equalsIgnoreCase(sRS_BuyerTaxEntType)
							&& sLOCAL.equalsIgnoreCase(sRS_isLocal)
					) return rs.getString(Ind_Tax_Calc.sColumnName_Tax_ID);
				}
			}
			
		} catch (SQLException e) 
		{
			log.saveError("Ind_Tax_Calc-CalcGST_Tax_ID ERROR:", e);
		}		
		return sStandard_Tax_ID;
	}
		
		
	
	private void setInd_Inv_Params(Properties ctx, MInvoice mi)
	{
		try
		{
			this.ctx=ctx;
			 mParm_Inv=mi;
			InvoiceDate = mParm_Inv.getDateInvoiced();
			//iBPartner_ID = mParm_Inv.getC_BPartner_ID();
			//this.ctx = ctx;
			iClient_ID= Env.getAD_Client_ID(ctx);
			iBPartner_ID= mi.getC_BPartner_ID();
			//mParm_Inv.setC_BPartner_ID(iBPartner_ID);
			
			MStatLoc = new MInd_Statutory_Org(ctx, mParm_Inv.getAD_Org_ID());
			mBPStatLoc = new MInd_Statutory_BPartner(ctx, iBPartner_ID);	
			iMyLocation_ID = MStatLoc.getC_Location_ID();;
			iBPartnerLocation_ID = mBPStatLoc.getC_Location_ID();;
			iMyEntityType_ID=MStatLoc.getInd_Tax_Entity_Type_ID();
			iBPartnerEntity_Type_ID=mBPStatLoc.getInd_Tax_Entity_Type_ID();
			sURD = Integer.toString(MInd_Tax_Entity_Type.getEntityType(MInd_Tax_Entity_Type.sUnRegisteredTaxEntity));
			sBuyerEntityType=""; sSellerEntityType="";		
			sTax_Category_ID_GST = Integer.toString((new MInd_Tax_Category(ctx, MInd_Tax_Rules_MV.sTaxCategory_GST)).getInd_Tax_Category_ID()); // confirm that its GST
			MInd_Tax_Entity_Type MTaxEntLoc = new MInd_Tax_Entity_Type(ctx, iMyEntityType_ID, null);
			isSales = mParm_Inv.isSOTrx()?"Y":"N";
			sLOCAL="Y"; //, sITC="Y", sComposite="N";
			sStandard_Tax_ID= MInd_Tax_Rules_MV.getTax_ID(MInd_Tax_Rules_MV.sTaxStandard);
			sStandard_Tax_ID= (sStandard_Tax_ID==null?"0":sStandard_Tax_ID);
			////////find the invoice line tab////////
			//mParm_Inv.saveEx();
			////////////////////////////////////////////
			MLocation loc1=null, loc2 = null; //
			
			int iLoc1_Region_ID=0, iLoc2_Region_ID=0;
			
			//iCompositeTaxEntityType_ID=MTaxEntLoc.getiCompositeDealerTaxEntity_ID();
			//if(iMyEntityType_ID==iCompositeTaxEntityType_ID) sComposite="Y";
			// location processing - to find if the transaction is local
			if(iMyLocation_ID != 0)
				{
				loc1 = new MLocation(ctx, iMyLocation_ID, null);
				iLoc1_Region_ID= loc1.getC_Region_ID();
				}
			if(iBPartnerLocation_ID!=0) 
				{
					loc2=new MLocation(ctx, iBPartnerLocation_ID, null);
					iLoc2_Region_ID= loc2.getC_Region_ID();
				}
			
			
			if( loc2 == null || loc1 == null 
					|| iLoc1_Region_ID == 0 || iLoc2_Region_ID == 0
					|| loc1.getC_Region_ID()== loc2.getC_Region_ID()
					) sLOCAL="Y";
			else sLOCAL="N";
			
			if(isSales=="Y")
			{
				sBuyerEntityType= Integer.toString(iBPartnerEntity_Type_ID);
				sSellerEntityType=Integer.toString(iMyEntityType_ID);
			}
			else 
			{
				sBuyerEntityType= Integer.toString(iMyEntityType_ID);
				sSellerEntityType=Integer.toString(iBPartnerEntity_Type_ID);
			}
			if(sBuyerEntityType == null || sBuyerEntityType.equalsIgnoreCase("0")) 
				sBuyerEntityType= sURD;
			if(sSellerEntityType == null || sSellerEntityType.equalsIgnoreCase("0")) 
				sSellerEntityType= sURD;
		} catch (SQLException e) 
		{
			log.saveError("Ind_Tax_Calc Error:", e);
		}
	}
	
	private void setInd_Inv_Params(Properties ctx, GridTab mLocTab, GridField mField) 
	{
		
		this.mTab=mLocTab;
		this.mField=mField;
		if(mLocTab.getTableName().equalsIgnoreCase(MInvoice.Table_Name))
		{
			mParm_Inv=(MInvoice) mLocTab.getTableModel().getPO(0);
		}
		else
		{
			mParm_Inv=(MInvoice) mLocTab.getParentTab().getTableModel().getPO(0);
		}
			
		setInd_Inv_Params(ctx, mParm_Inv);
		//int i_Inv_ID = (int) mLocTab.getField(MInvoice.COLUMNNAME_C_Invoice_ID).getValue();
			
			
	}

}
