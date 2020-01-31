package com.cspl.hsnmaster;

import java.sql.ResultSet;
import java.util.Properties;

public class MInd_HSN_SAC_Rates extends X_Ind_HSN_SAC_Rates 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6141917137634712296L;
	public MInd_HSN_SAC_Rates(Properties ctx, ResultSet rs, String trxName) 
	{
		super(ctx, rs, trxName);
	}
	public MInd_HSN_SAC_Rates(Properties ctx, int Ind_HSN_SAC_Rates_ID, String trxName) 
	{
		super(ctx, Ind_HSN_SAC_Rates_ID, trxName);
	}

	
	
}
