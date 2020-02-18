package com.cspl.ind.tables;

import java.math.BigDecimal;

import org.compiere.model.I_C_Payment;

public interface IND_C_Payment extends I_C_Payment
{
	public static final String COLUMNNAME_IND_C_TAX_ID = "IND_C_Tax_ID";
	/** Set Tax.
	  * Tax identifier
	  */
	public void setIND_C_Tax_ID (int IndCTaxId);

	/** Get Tax.
	  * Tax identifier
	  */
	public int getIND_C_Tax_ID();
	
	//-----------------
	
	public static final String COLUMNNAME_IND_TDS_AMT = "IND_TDS_Amt";
	/** Set Tax.
	  * Tax identifier
	  */
	public void setIND_TDS_Amt (BigDecimal IndTdsAmt);

	/** Get Tax.
	  * Tax identifier
	  */
	public int getIND_TDS_Amt();
	
	public static final String COLUMNNAME_IND_Net_Payment_Amt = "IND_Net_Payment_Amt";
	/** Set Tax.
	  * Tax identifier
	  */
	public void setIND_Net_Payment_Amt (BigDecimal IndNetPmtAmt);

	/** Get Tax.
	  * Tax identifier
	  */
	public int getIND_Net_Payment_Amt();


}
