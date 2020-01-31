package com.cspl.ind.taxrules.callouts;

import java.util.Properties;


import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

import org.compiere.model.MInvoiceLine;

import org.compiere.util.CLogger;
import com.cspl.ind.taxrules.logic.Ind_Tax_Calc;


public class Ind_Invoice_Callout implements IColumnCallout 
{
	CLogger log = CLogger.getCLogger(Ind_Invoice_Callout.class);

	@Override
	public String start(Properties ctx, int WindowNo, 
			GridTab mTab, GridField mField, Object value, Object oldValue) 
	{
	
		if(mField.getValue() != null) 
		{	if(
				( 	mTab.getTableName().equalsIgnoreCase(MInvoiceLine.Table_Name) 
					&& 
					(	mField.getColumnName().equals(MInvoiceLine.COLUMNNAME_M_Product_ID)
						|| mField.getColumnName().equalsIgnoreCase(MInvoiceLine.COLUMNNAME_C_Charge_ID) 
					)  
				)
			) { ProcessTax(ctx, WindowNo, mTab, mField); } 	// Processes for MinvoiceLine where field is Charge_id or Product_id
		}
		
		return null;
		
	}

private boolean ProcessTax(Properties ctx, int windowNo, GridTab mTab, GridField mField) 
{
	
	Ind_Tax_Calc ITC = new Ind_Tax_Calc(ctx, mTab, mField);
	int i= mTab.getCurrentRow();
	MInvoiceLine mil = (MInvoiceLine) ( mTab.getTableModel().getPO(i)  );
	
	String sC_Tax_ID = ITC.processInvoiceLine(ctx, mil);
	if (sC_Tax_ID!=null) 
	{ 
		mTab.setValue ( MInvoiceLine.COLUMNNAME_C_Tax_ID, Integer.parseInt(sC_Tax_ID) );
		return true;
	}
	else return false;
}
	
}
