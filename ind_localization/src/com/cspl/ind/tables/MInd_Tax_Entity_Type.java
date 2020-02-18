package com.cspl.ind.tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.compiere.util.CLogger;
import org.compiere.util.DB;

public class MInd_Tax_Entity_Type extends X_Ind_Tax_Entity_Type
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8300658444611878816L;

	static CLogger log = CLogger.getCLogger(MInd_Tax_Entity_Type.class);
	
	public static String sUnRegisteredTaxEntity		= "URD";
	public static String sCompositeDealerTaxEntity	= "CD";
	
	private int iUnRegisteredTaxEntity_ID = 0;
	private int iCompositeDealerTaxEntity_ID=0;
	
	// this is used to store any fixed rates associated with an entity type - 
	//eg: Composite dealer might have 1% till end of 2019, then move to 2%. 
	//private ArrayList <MInd_Tax_Category_Rate> clFixedRates;
	
	//public static String sUnRegisteredTaxEntity_ID	= getEntityType(sUnRegisteredTaxEntity);
	
	public MInd_Tax_Entity_Type(Properties ctx, ResultSet rs, String trxName) throws SQLException  //not used
	{
		super(ctx, rs, trxName);
		set_Class_Variables(ctx, rs);
	}	

	public MInd_Tax_Entity_Type(Properties ctx, int Ind_Tax_Entity_Type_ID, String trxName) throws SQLException 
	{
		super(ctx, Ind_Tax_Entity_Type_ID, trxName);	
		set_Class_Variables(ctx, Ind_Tax_Entity_Type_ID );
	}

	
	public MInd_Tax_Entity_Type(Properties ctx, String sInd_Tax_Entity_Type_Value, Object trxName) throws NumberFormatException, SQLException 
	{
		this(ctx, getEntityType(sInd_Tax_Entity_Type_Value), null) ;
	}



	public static int getEntityType(String sTax_Entity_Abbrev) throws SQLException
	{
		String sql = "Select "; ResultSet rs=null;
		sql += MInd_Tax_Entity_Type.COLUMNNAME_Ind_Tax_Entity_Type_ID;
		sql += " from " + MInd_Tax_Entity_Type.Table_Name;
		sql += " Where " + MInd_Tax_Entity_Type.COLUMNNAME_Value;
		sql += " = ?";
		
		
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ps.setString( 1, sTax_Entity_Abbrev);
		try {
			rs = ps.executeQuery();
			while (rs.next())
			{
				return rs.getInt(MInd_Tax_Entity_Type.COLUMNNAME_Ind_Tax_Entity_Type_ID);
			}
		} catch (SQLException e) 
		{
			log.saveError("Ind_Invoice_Callout ERROR:", e);
		}
		return 0;

	}
	
	private void set_Class_Variables(Properties ctx,ResultSet rs) throws SQLException 
	{
		set_URD_CRD();
		//this.clFixedRates= null;
	}
	private void set_Class_Variables(Properties ctx,int Ind_Tax_Entity_Type_ID) throws SQLException 
	{
		set_URD_CRD();
		//this.clFixedRates= getMInd_Tax_Category_Rates(ctx, Ind_Tax_Entity_Type_ID);
		
	}
	
	/*private ArrayList<MInd_Tax_Category_Rate> getMInd_Tax_Category_Rates
		(Properties ctx, int ind_Tax_Entity_Type_ID) throws SQLException
	{
		ArrayList<MInd_Tax_Category_Rate> loc_MInd_TaxCatRate = new ArrayList <MInd_Tax_Category_Rate> (); 
		ResultSet rs=null;
		String sql = "Select "; 
		sql += MInd_Tax_Category_Rate.COLUMNNAME_Ind_Tax_Category_Rate_ID;
		sql += " from " + MInd_Tax_Category_Rate.Table_Name;
		sql += " Where " + MInd_Tax_Category_Rate.COLUMNNAME_Ind_Tax_Entity_Type_ID;
		sql += " = ?";
		
		
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ps.setInt( 1, ind_Tax_Entity_Type_ID);
		try {
			rs = ps.executeQuery();
			while (rs.next())
			{
				loc_MInd_TaxCatRate.add
								( new MInd_Tax_Category_Rate(ctx 
								,rs.getInt(MInd_Tax_Category_Rate.COLUMNNAME_Ind_Tax_Category_Rate_ID)
								, null)) ;
			}
		} catch (SQLException e) 
		{
			log.saveError("Ind_Invoice_Callout ERROR:", e);
		}
		return loc_MInd_TaxCatRate;
	}*/

	private void set_URD_CRD() throws SQLException
	{
		this.iUnRegisteredTaxEntity_ID=getEntityType(MInd_Tax_Entity_Type.sUnRegisteredTaxEntity);
		this.iCompositeDealerTaxEntity_ID=getEntityType(MInd_Tax_Entity_Type.sCompositeDealerTaxEntity);
	}
	

	public int getiUnRegisteredTaxEntity_ID() {
		return iUnRegisteredTaxEntity_ID;
	}


	public int getiCompositeDealerTaxEntity_ID() {
		return iCompositeDealerTaxEntity_ID;
	}

	/*public ArrayList <MInd_Tax_Category_Rate> getClFixedRates() {
		return clFixedRates;
	}*/

/*	public void setClFixedRates(ArrayList <MInd_Tax_Category_Rate> clFixedRates) {
		this.clFixedRates = clFixedRates;
	}
*/
	

	
	
}
