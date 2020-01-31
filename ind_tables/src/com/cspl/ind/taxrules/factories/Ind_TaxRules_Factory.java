package com.cspl.ind.taxrules.factories;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;

//import com.cspl.ind.table.extensions.MInd_Tax_Category;
//import com.cspl.ind.taxrules.callouts.*;
import com.cspl.ind.taxrules.callouts.*;

import org.compiere.model.MInvoice;
//import org.compiere.model.I_C_Tax;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPayment;
import com.cspl.ind.table.extensions.*;

public class Ind_TaxRules_Factory implements IColumnCalloutFactory
{

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) 
	{
		List<IColumnCallout> clsCallouts = new ArrayList<IColumnCallout>();
		// DO ALL THE CHECKS TO GET LIST OF CALLOUTS...
		if(
				(tableName.equalsIgnoreCase(MInvoiceLine.Table_Name) &&
				(columnName.equalsIgnoreCase(MInvoiceLine.COLUMNNAME_M_Product_ID)
				|| columnName.equalsIgnoreCase(MInvoiceLine.COLUMNNAME_C_Charge_ID)
				))
			
				// ||
				//(tableName.equalsIgnoreCase(MInvoice.Table_Name) 
				//&& columnName.equalsIgnoreCase(MInvoice.COLUMNNAME_C_BPartner_ID))
				
			) 
		{clsCallouts.add(new Ind_Invoice_Callout());}
		else if(tableName.equalsIgnoreCase(MPayment.Table_Name) &&
					(
							columnName.equalsIgnoreCase(IND_C_Payment.COLUMNNAME_IND_C_TAX_ID)
							|| columnName.equalsIgnoreCase(MPayment.COLUMNNAME_PayAmt)      
					)
				)
		{
			//TODO add payment callout here.
			{clsCallouts.add(new Ind_Payment_Tax_Callout() ); };
		}
	
		
		return ( clsCallouts != null ? 
				( clsCallouts.toArray(new IColumnCallout[0]) )
				: ( new IColumnCallout[0])  );
	}

}
