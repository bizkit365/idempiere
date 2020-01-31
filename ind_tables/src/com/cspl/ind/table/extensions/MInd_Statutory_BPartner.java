package com.cspl.ind.table.extensions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.model.I_C_Location;
import org.compiere.util.CLogger;
import org.compiere.util.DB;

import com.cspl.ind.tables.X_Ind_Statutory_BPartner;

public class MInd_Statutory_BPartner extends X_Ind_Statutory_BPartner
{

	/**
	 * 
	 */
	static CLogger log = CLogger.getCLogger(MInd_Statutory_Org.class);
	
	private static final long serialVersionUID = -6637834952772169867L;
	
	public MInd_Statutory_BPartner(Properties ctx, ResultSet rs, String trxName) 
	{
		super(ctx, rs, trxName);
	}
	public MInd_Statutory_BPartner(Properties ctx, int Ind_Statutory_BPartner_ID, String trxName) 
	{
		super(ctx, Ind_Statutory_BPartner_ID, trxName);
	}
	public MInd_Statutory_BPartner(Properties ctx, int AD_Org_ID) throws SQLException 
	{

		this(ctx, getInd_Stat_BP_ID( AD_Org_ID), null);
	}
	private static int getInd_Stat_BP_ID(int C_BPartner_ID) throws SQLException
	{
		ResultSet rs=null;
		String sql = "Select "; 
		sql += MInd_Statutory_BPartner.COLUMNNAME_IND_Statutory_BPartner_ID;
		sql += " from " + MInd_Statutory_BPartner.Table_Name;
		sql += " where " + MInd_Statutory_BPartner.COLUMNNAME_C_BPartner_ID + "= ?";
		
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ps.setLong( 1, C_BPartner_ID);
		try {
			rs = ps.executeQuery();
			while (rs.next())
			{
				return rs.getInt(MInd_Statutory_BPartner.COLUMNNAME_IND_Statutory_BPartner_ID);
			}
		} catch (SQLException e) 
		{
			log.saveError("MInd_Statutory_Org ERROR:", e);
		}
		return 0;
	}

}
