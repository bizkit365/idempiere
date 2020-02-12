package com.cspl.ind.taxrules.eventhandlers;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.GridTab;
import org.compiere.model.MInvoice;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import com.cspl.ind.taxrules.logic.Ind_Tax_Calc;

import java.util.Properties;

public class Ind_Invoice_Tax_Events extends AbstractEventHandler 
{
	CLogger log = CLogger.getCLogger(Ind_Invoice_Tax_Events.class);
	@Override
	protected void doHandleEvent(Event event) 
	{
		PO po = getPO(event);
		
		if(po instanceof MInvoice)
		{
			if(po.is_ValueChanged(po.get_ColumnIndex(MInvoice.COLUMNNAME_C_BPartner_ID)))
			{
				ReCalc_Invoice_Line_Tax(event, po);
			}
			
		}
	}


	@Override
	protected void initialize() 
	{
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MInvoice.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MInvoice.Table_Name);
	}

	private void ReCalc_Invoice_Line_Tax(Event event, PO po) 
	{
		Properties ctx = po.getCtx();
		MInvoice mi = (MInvoice) po;
		Ind_Tax_Calc ITC = new Ind_Tax_Calc(ctx, mi);
		ITC.processInvoice(ctx, mi);
	}
}