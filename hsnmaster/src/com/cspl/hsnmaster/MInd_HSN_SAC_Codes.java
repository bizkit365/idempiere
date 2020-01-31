package com.cspl.hsnmaster;

import java.sql.ResultSet;
import java.util.Properties;

public class MInd_HSN_SAC_Codes extends X_Ind_HSN_SAC_Codes 
{
	 

	/**
	 * 
	 */
	private static final long serialVersionUID = -4573161297460340144L;

	public MInd_HSN_SAC_Codes(Properties ctx, int Ind_HSN_SAC_Codes_ID, String trxName) 
	{
		super(ctx, Ind_HSN_SAC_Codes_ID, trxName);
	}
		
	public MInd_HSN_SAC_Codes(Properties ctx, ResultSet rs, String trxName) 
	{
		super(ctx, rs, trxName);	
	}

	
}
