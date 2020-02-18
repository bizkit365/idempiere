
package com.cspl.ind.tables;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;

import javax.sql.RowSet;

import org.compiere.model.*;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

//import com.cspl.ind.taxrules.callouts.Ind_Invoice_Callout;

import java.sql.Timestamp;

public class MInd_Tax_Rules_MV extends X_Ind_Tax_Rules_MV
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7189103239871268073L;
	CLogger log = CLogger.getCLogger(MInd_Tax_Rules_MV.class);
	
///// RELATES TO THE PGADMIN FUNCTION CALL TO Get_Ind_HSN_Tax_Details
	private static String sGetTaxDetails 					= "get_Ind_hsn_tax_details";
	private static String sColumnName_Tax_ID 				= "ret_c_Tax_id";
	private static String sColumnName_Tax_Category_ID 		= "ret_tax_category_id";
	private static String sColumnName_Buyer_entity_Type_ID 	= "ret_ind_buyer_tax_entity_type_id";
	private static String sColumnName_Seller_entity_Type_ID	= "ret_ind_seller_tax_entity_type_id";
	private static String sColumnName_GST_Rate 				= "ret_gst_rate";
	private static String sColumnName_Cess_Rate 			= "ret_cess_rate";
	private static String sColumnName_isITC 				= "ret_isitc";
	private static String sColumnName_isLocal 				= "ret_islocal";
	public static String sTaxCategory_GST 					= "GST";
	public static String sTaxStandard						= "Standard";
	
	//////////////////////////////////////////////////////////////////////////
	
	public static String sInd_HSN_Tax_Details="get_ind_hsn_tax_details";
	
	public MInd_Tax_Rules_MV(Properties ctx, RowSet rs, String trxName) 
	{
		super(ctx, rs, trxName);
	}
	public MInd_Tax_Rules_MV(Properties ctx, int Ind_Tax_Rules_MV_ID, String trxName) 
	{
		super(ctx, Ind_Tax_Rules_MV_ID, trxName);
	}
	public MInd_Tax_Rules_MV(Properties ctx, int m_product_id,int m_ind_tax_category_id, Timestamp TrxDate, String trxName)
	{
		super(ctx, getRS(m_product_id, m_ind_tax_category_id, TrxDate), trxName);
	}
	public static RowSet getRS(int m_product_id, int m_ind_tax_category_id, Timestamp trxDate) 
	{
		String s1 = "select " + sInd_HSN_Tax_Details ;
		s1 += " cast(" + Env.AD_CLIENT_ID + " numeric) , ";
		s1 += " cast(" + m_product_id + " numeric) , ";
		s1 += " cast(" + m_ind_tax_category_id + " numeric) , ";
		s1 += " cast ( " + trxDate + " as timestamp without time zone ) )";
		
		return DB.getRowSet(s1);
	}
	public static String getTax_ID(String Name) throws SQLException
	{
		String sql="Select ";
		sql += MTax.COLUMNNAME_C_Tax_ID;
		sql += " from " + MTax.Table_Name + " where upper(" + MTax.COLUMNNAME_Name +") = upper('" 
					+ Name +"')" ;
		sql += " and " + MTax.COLUMNNAME_AD_Client_ID ;
		sql += " = '" + Env.getAD_Client_ID(Env.getCtx()) + "'";
		
		//sql += Env.getAD_Client_ID(Env.getCtx());
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		;
		
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			return rs.getString(MTax.COLUMNNAME_C_Tax_ID);
		}
		return null;
		 
	}
	
	public static ResultSet GetTaxCursor
	(int iClient_ID, int iItem_ID
			,String sColumnName,String  sTaxCategory 
			,boolean isCharge, Timestamp InvoiceDate 
			,String sFixedRate
			,double dTax_Rate, double dCess_Rate, String isITC
	) 		throws SQLException
	{
		String sql = "Select "  
		+ MInd_Tax_Rules_MV.sColumnName_Tax_ID +","
		+ MInd_Tax_Rules_MV.sColumnName_Tax_Category_ID +","
		+ MInd_Tax_Rules_MV.sColumnName_Buyer_entity_Type_ID  +","
		+ MInd_Tax_Rules_MV.sColumnName_Seller_entity_Type_ID +","
		+ MInd_Tax_Rules_MV.sColumnName_GST_Rate +","
		+ MInd_Tax_Rules_MV.sColumnName_Cess_Rate +","
		+ MInd_Tax_Rules_MV.sColumnName_isITC +","
		+ MInd_Tax_Rules_MV.sColumnName_isLocal 
		+ " from "
		+ MInd_Tax_Rules_MV.sGetTaxDetails;
		sql += "( ";
		sql += "cast(? as numeric)" ; //client_id #1
		sql += ",cast(? as character varying)"; // Tax Category - GST etc #2
		sql += ",cast(? as timestamp without time zone)"; // invoice date #3
		sql += ",cast(? as numeric)"; //product_id / resource_id #4
		sql +=  ",cast(?  as Character) "; // "Y" = is a charge. "N" is a product #5
		sql +=  ",cast(?  as Character) "; // isFixed Rate (for composite dealers)
		sql += " , cast(? as numeric) "; // fixed rate
		sql += " , cast(? as numeric) "; // fixed Cess rate
		sql +=  ",cast(?  as Character) "; // isITC - default N for composite dealers
		sql += ")";
		//System.out.println("SQL STMT: " + sql);
	
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
												ResultSet.TYPE_SCROLL_INSENSITIVE, 
												ResultSet.CONCUR_READ_ONLY);
		ps.setString(1, Integer.toString(iClient_ID) );
		ps.setString(2, MInd_Tax_Rules_MV.sTaxCategory_GST );
		ps.setTimestamp(3, InvoiceDate );
		ps.setString(4, Integer.toString(iItem_ID) );
		ps.setString(5, (isCharge?"Y":"N") );
		ps.setString(6, sFixedRate);  // isFixed Rate (for composite dealers)
		ps.setString(7, Double.toString(dTax_Rate));  // fixed rate
		ps.setString(8, Double.toString(dCess_Rate));   // fixed Cess rate
		ps.setString(9, isITC); // isITC - default N for composite dealers
		
		//System.out.println("SQL STMT: " + ps.toString());
		return  ps.executeQuery();
	}
	
		public static ResultSet GetTaxCursor (int iClient_ID, int iItem_ID
			,String sColumnName,String  sTaxCategory 
			,boolean isCharge, Timestamp InvoiceDate 
			) throws SQLException
	{
		return GetTaxCursor(iClient_ID, iItem_ID
		,sColumnName,sTaxCategory 
		,isCharge, InvoiceDate
		, "N", 0,0,"N"
		);
	}


}
