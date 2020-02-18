package com.cspl.ind.tables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MInd_Statutory_Org extends X_Ind_Statutory_Org
{

	/**
	 * 
	 */
	

	private static final long serialVersionUID = 7271581755189596566L;
	static CLogger log = CLogger.getCLogger(MInd_Statutory_Org.class);
	
	public MInd_Statutory_Org(Properties ctx, ResultSet rs, String trxName) 
	{
		super(ctx, rs, trxName);
	}
	public MInd_Statutory_Org(Properties ctx, int Ind_Statutory_Org_ID, String trxName) 
	{
		super(ctx, Ind_Statutory_Org_ID, trxName);
	}
	
	public MInd_Statutory_Org (Properties ctx, int AD_Org_ID) throws SQLException 
	{
		this(ctx,getInd_Stat_Org_ID( AD_Org_ID), null);
	}
	private static int getInd_Stat_Org_ID(int AD_Org_ID) throws SQLException
	{
		
		ResultSet rs=null;
		String sql = "Select "; 
		sql += MInd_Statutory_Org.COLUMNNAME_IND_Statutory_Org_ID;
		sql += " from " + MInd_Statutory_Org.Table_Name;
		sql += " where " + MInd_Statutory_Org.COLUMNNAME_AD_Org_ID + "= ?";
		
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ps.setLong( 1, AD_Org_ID);
		try {
			rs = ps.executeQuery();
			while (rs.next())
			{
				return rs.getInt(MInd_Statutory_Org.COLUMNNAME_IND_Statutory_Org_ID);
			}
		} catch (SQLException e) 
		{
			log.saveError("MInd_Statutory_Org ERROR:", e);
		}
		return 0;
	}
	
}
