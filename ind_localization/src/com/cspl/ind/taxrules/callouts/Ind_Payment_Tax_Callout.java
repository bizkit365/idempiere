package com.cspl.ind.taxrules.callouts;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
//import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPayment;
import org.compiere.model.MTax;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import com.cspl.ind.tables.IND_C_Payment;

public class Ind_Payment_Tax_Callout implements IColumnCallout 
{
	CLogger log = CLogger.getCLogger(Ind_Payment_Tax_Callout.class);
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		if(mField.getValue() != null) 
		{	
			if(
				( 	mTab.getTableName().equalsIgnoreCase(MPayment.Table_Name) 
					&& mTab.getField(IND_C_Payment.COLUMNNAME_IND_C_TAX_ID).getValue() != null					
					&& (	
							mField.getColumnName().equals(IND_C_Payment.COLUMNNAME_IND_C_TAX_ID)
							|| mField.getColumnName().equalsIgnoreCase(MPayment.COLUMNNAME_PayAmt) 
					
						)  
				)
			) 
			{
				setTaxAmt(ctx, mTab, mField);
			}
		}
		
		return null;
	}
	private void setTaxAmt(Properties ctx, GridTab mTab, GridField mField)
	{
		Integer iTax_ID=(Integer) mTab.getField(IND_C_Payment.COLUMNNAME_IND_C_TAX_ID).getValue();
		BigDecimal dbPayAmt = (BigDecimal) (mTab.getField(MPayment.COLUMNNAME_PayAmt).getValue());
		
		if(iTax_ID.compareTo(0)>0 && dbPayAmt.compareTo(Env.ZERO)>0)
		{
			MTax mTaxLOC= new MTax(ctx,iTax_ID.intValue(), null);
			BigDecimal dTaxAmt = mTaxLOC.calculateTax(dbPayAmt, false, 3);
			BigDecimal NetPayAmt = dbPayAmt.add(dTaxAmt);
			
			GridField mf = mTab.getField(IND_C_Payment.COLUMNNAME_IND_TDS_AMT);
			mf.setValue(dTaxAmt, false);
			mf = mTab.getField(IND_C_Payment.COLUMNNAME_IND_Net_Payment_Amt);
			mf.setValue(NetPayAmt, false);
		}
	}
	
}
