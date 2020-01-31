package com.cspl.ind.table.extensions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.util.CLogger;
import org.compiere.util.DB;

import com.cspl.ind.tables.*;

public class MInd_Tax_Category extends X_Ind_Tax_Category
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7611120271575420664L;
	static CLogger log = CLogger.getCLogger(MInd_Tax_Category.class);
	
	public MInd_Tax_Category(Properties ctx, ResultSet rs, String trxName) 
	{
		super(ctx, rs, trxName);
	}
	public MInd_Tax_Category(Properties ctx, int Ind_Tax_Category_ID, String trxName) 
	{
		super(ctx, Ind_Tax_Category_ID, trxName);
	}
	public MInd_Tax_Category(Properties ctx, String sTax_Category_Value) throws SQLException 
	{
		this(ctx, getInd_Tax_Cat(ctx, sTax_Category_Value), null);
	}
	
	public static int getInd_Tax_Cat(Properties ctx, String sTax_Category_Value) throws SQLException
	{
		String sql = "Select "; ResultSet rs=null;
		sql += MInd_Tax_Category.COLUMNNAME_Ind_Tax_Category_ID;
		sql += " from " + MInd_Tax_Category.Table_Name;
		sql += " Where " + MInd_Tax_Category.COLUMNNAME_Value;
		sql += " = ?";
		
		
		PreparedStatement ps = DB.getConnectionID().prepareStatement(sql,  
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ps.setString( 1, sTax_Category_Value);
		try {
			rs = ps.executeQuery();
			while (rs.next())
			{
				return rs.getInt(MInd_Tax_Category.COLUMNNAME_Ind_Tax_Category_ID);
			}
		} catch (SQLException e) 
		{
			log.saveError("IND_Tax_Category Module:", e);
		}
		return 0;
	}

}
