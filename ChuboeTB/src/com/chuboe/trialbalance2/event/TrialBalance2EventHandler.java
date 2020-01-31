package com.chuboe.trialbalance2.event;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

import com.chuboe.trialbalance2.model.I_Chuboe_TrialBalance_Hdr;
import com.chuboe.trialbalance2.model.X_Chuboe_TrialBalance_Hdr;

public class TrialBalance2EventHandler extends AbstractEventHandler {

	@Override
	protected void doHandleEvent(Event event) {
		if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)){
			PO po = getPO(event);
			if (po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_AccountFrom_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_AccountTo_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_C_Calendar_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_DateAcctFrom))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_DateAcctTo))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_Ref_Org_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_C_AcctSchema_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_AD_OrgTrx_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_C_Activity_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_C_BPartner_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_C_Campaign_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_TB_Currency_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_C_Project_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_M_Product_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_PostingType))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_User1_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_User2_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_UserElement1_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_UserElement2_ID))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_Activity_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_BP_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_Campaign_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_OrgTrx_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_Product_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_Project_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_User1_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_User2_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_UserElem1_NullReq))
					|| po.is_ValueChanged(po.get_ColumnIndex(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_ChuBoe_UserElem2_NullReq))
					){
				po.set_ValueOfColumn(X_Chuboe_TrialBalance_Hdr.COLUMNNAME_AD_PInstance_ID, null);
			}
		}

	}

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, X_Chuboe_TrialBalance_Hdr.Table_Name);

	}

}
