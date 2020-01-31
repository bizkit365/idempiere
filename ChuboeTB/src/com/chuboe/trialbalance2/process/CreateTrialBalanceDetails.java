package com.chuboe.trialbalance2.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.adempiere.model.GenericPO;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import com.chuboe.trialbalance2.model.X_Chuboe_TrialBalance_Hdr;

public class CreateTrialBalanceDetails extends SvrProcess {
	
	private int m_recordID;
	private int m_tableID;

	@Override
	protected void prepare() {
		m_recordID = this.getRecord_ID();
		m_tableID = this.getTable_ID();
		
		//TODO - check to make sure calling from the correct table
	}

	@Override
	protected String doIt() throws Exception {
		
		StringBuilder sql = new StringBuilder("delete from chuboe_trialbalance_detail where chuboe_trialbalance_hdr_id = ?");
		DB.executeUpdateEx(sql.toString(), new Object[]{m_recordID}, get_TrxName());
		
		X_Chuboe_TrialBalance_Hdr hdr = new X_Chuboe_TrialBalance_Hdr(getCtx(), m_recordID, get_TrxName());
		hdr.setAD_PInstance_ID(getAD_PInstance_ID());
		hdr.saveEx();
		
		List<Object> paramsList = new ArrayList<Object>();
		paramsList.add(hdr.getChuboe_TrialBalance_Hdr_ID());//1
		paramsList.add(hdr.getCreated());
		paramsList.add(hdr.getCreatedBy());
		paramsList.add(hdr.getUpdated());
		paramsList.add(hdr.getUpdatedBy()); //5
		paramsList.add(getAD_PInstance_ID());
		paramsList.add(hdr.getC_Calendar_ID());
		paramsList.add(hdr.getChuBoe_DateAcctTo()); 
		paramsList.add(hdr.getChuBoe_AccountFrom_ID());
		paramsList.add(hdr.getChuBoe_AccountTo_ID()); //10
		
		sql = new StringBuilder("Insert Into chuboe_trialbalance_detail "
				+ "(fact_acct_id, "
				+ "    ad_client_id, "
				+ "    ad_org_id, "
				+ "    isactive, "
				+ "    created, "
				+ "    createdby, "
				+ "    updated, "
				+ "    updatedby, "
				+ "    c_acctschema_id, "
				+ "    account_id, " 
				+ "    datetrx, "
				+ "    dateacct, "
				+ "    c_period_id, "
				+ "    ad_table_id, "
				+ "    record_id, "
				+ "    line_id, "
				+ "    gl_category_id, "
				+ "    gl_budget_id, "
				+ "    c_tax_id, "
				+ "    m_locator_id, "
				+ "    postingtype, "
				+ "    c_currency_id, "
				+ "    amtsourcedr, "
				+ "    amtsourcecr, "
				+ "    amtacctdr, "
				+ "    amtacctcr, "
				+ "    c_uom_id, "
				+ "    qty, "
				+ "    m_product_id, "
				+ "    c_bpartner_id, "
				+ "    ad_orgtrx_id, "
				+ "    c_locfrom_id, "
				+ "    c_locto_id, "
				+ "    c_salesregion_id, "
				+ "    c_project_id, " 
				+ "    c_campaign_id, "
				+ "    c_activity_id, "
				+ "    user1_id, "
				+ "    user2_id, "
				+ "    description, "
				+ "    a_asset_id, "
				+ "    c_subacct_id, "
				+ "    userelement1_id, "
				+ "    userelement2_id, "
				+ "    c_projectphase_id, "
				+ "    c_projecttask_id, "
				+ "    chuboe_trialbalance_hdr_id, "
				+ "    chuboe_trialbalance_detail_v_id, "
				+ "    hdr_created, "
				+ "    hdr_createdby, "
				+ "    hdr_updated, "
				+ "    hdr_updatedby, "
				+ "    accounttype, "
				+ "    ad_pinstance_id, "
				+ "    isChuBoeCurrent "
				+ " ) "
				+ "select "
				+ "    fa.fact_acct_id, fa.ad_client_id, fa.ad_org_id, fa.isactive, fa.created, fa.createdby, fa.updated, fa.updatedby, fa.c_acctschema_id, fa.account_id, fa.datetrx, fa.dateacct, fa.c_period_id, fa.ad_table_id, fa.record_id, fa.line_id, fa.gl_category_id, fa.gl_budget_id, fa.c_tax_id, fa.m_locator_id, fa.postingtype, fa.c_currency_id, fa.amtsourcedr, fa.amtsourcecr, fa.amtacctdr, fa.amtacctcr, fa.c_uom_id, fa.qty, fa.m_product_id, fa.c_bpartner_id, fa.ad_orgtrx_id, fa.c_locfrom_id, fa.c_locto_id, fa.c_salesregion_id, fa.c_project_id, fa.c_campaign_id, fa.c_activity_id, fa.user1_id, fa.user2_id, fa.description, fa.a_asset_id, fa.c_subacct_id, fa.userelement1_id, fa.userelement2_id, fa.c_projectphase_id, fa.c_projecttask_id, "
				+ "	? as ChuBoe_trialbalance_hdr_id, " //1
				+ "		fa.fact_acct_id AS ChuBoe_trialbalance_detail_v_id, "
				+ "	? AS hdr_created, " //2
				+ "	? AS hdr_createdby, " //3
				+ "	? AS hdr_updated, " //4
				+ "	? AS hdr_updatedby, " //5
				+ "		ev.accounttype, "
				+ "		?, " //6 ad_pinstance_id
				+ "CASE WHEN (ev.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar])) "
						+ "THEN 'Y' "
						+ "ELSE CASE WHEN fa.dateacct >= ChuBoe_fiscalstartdate(?, ?) THEN 'Y' ELSE 'N' END " //7, 8 h.c_calendar_id, h.dateacctto
						+ "END as isChuBoeCurrent "
				+ "FROM (((fact_acct fa "
				+ "	JOIN c_elementvalue ev ON ((fa.account_id = ev.c_elementvalue_id))) "
				+ "	LEFT JOIN c_elementvalue acctfrom ON ((? = acctfrom.c_elementvalue_id))) " //9 h.accountfrom_id
				+ "	LEFT JOIN c_elementvalue acctto ON ((? = acctto.c_elementvalue_id))) " //10 h.accountto_id
				+ "WHERE 1=1 "
				); 
		
		if (hdr.getC_AcctSchema_ID() > 0) {
			sql.append(" AND fa.c_acctschema_id = ? ");
			paramsList.add(hdr.getC_AcctSchema_ID());
		}
		
		if (hdr.getPostingType() != null && !hdr.getPostingType().equals("")) {
			sql.append(" AND fa.postingtype = ? ");
			paramsList.add(hdr.getPostingType());			
		}
		
		if (hdr.getChuBoe_TB_Currency_ID() > 0) {
			sql.append(" AND fa.c_currency_id = ? ");
			paramsList.add(hdr.getChuBoe_TB_Currency_ID());
		}
		
		if (hdr.getC_Activity_ID() > 0) {
			sql.append(" AND fa.c_activity_id = ? ");
			paramsList.add(hdr.getC_Activity_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_ACTIVITY_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_Activity_NullReq())) {
			sql.append(" AND fa.c_activity_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_ACTIVITY_NULLREQ_MustBeNull.equals(hdr.getChuBoe_Activity_NullReq())) {
			sql.append(" AND fa.c_activity_id is null ");
		}

		if (hdr.getC_BPartner_ID() > 0) {
			sql.append(" AND fa.c_bpartner_id = ? ");
			paramsList.add(hdr.getC_BPartner_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_BP_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_BP_NullReq())) {
			sql.append(" AND fa.c_bpartner_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_BP_NULLREQ_MustBeNull.equals(hdr.getChuBoe_BP_NullReq())) {
			sql.append(" AND fa.c_bpartner_id is null ");
		}

		if (hdr.getC_Campaign_ID() > 0) {
			sql.append(" AND fa.c_campaign_id = ? ");
			paramsList.add(hdr.getC_Campaign_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_CAMPAIGN_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_Campaign_NullReq())) {
			sql.append(" AND fa.c_campaign_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_CAMPAIGN_NULLREQ_MustBeNull.equals(hdr.getChuBoe_Campaign_NullReq())) {
			sql.append(" AND fa.c_campaign_id is null ");
		}

		if (hdr.getAD_OrgTrx_ID() > 0)	{
			sql.append(" AND fa.ad_orgtrx_id = ? ");
			paramsList.add(hdr.getAD_OrgTrx_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_ORGTRX_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_OrgTrx_NullReq())) {
			sql.append(" AND fa.ad_orgtrx_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_ORGTRX_NULLREQ_MustBeNull.equals(hdr.getChuBoe_OrgTrx_NullReq())) {
			sql.append(" AND fa.ad_orgtrx_id is null ");
		}

		
		if (hdr.getM_Product_ID() > 0) {
			sql.append(" AND fa.m_product_id = ? ");
			paramsList.add(hdr.getM_Product_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_PRODUCT_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_Product_NullReq())) {
			sql.append(" AND fa.m_product_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_PRODUCT_NULLREQ_MustBeNull.equals(hdr.getChuBoe_Product_NullReq())) {
			sql.append(" AND fa.m_product_id is null ");
		}
		
		if (hdr.getC_Project_ID() > 0) {
			sql.append(" AND fa.c_project_id = ? ");
			paramsList.add(hdr.getC_Project_ID());
		}

		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_PROJECT_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_Project_NullReq())) {
			sql.append(" AND fa.c_project_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_PROJECT_NULLREQ_MustBeNull.equals(hdr.getChuBoe_Project_NullReq())) {
			sql.append(" AND fa.c_project_id is null ");
		}

		if (hdr.getUser1_ID() > 0) {
			sql.append(" AND fa.user1_id = ? ");
			paramsList.add(hdr.getUser1_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USER1_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_User1_NullReq())) {
			sql.append(" AND fa.user1_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USER1_NULLREQ_MustBeNull.equals(hdr.getChuBoe_User1_NullReq())) {
			sql.append(" AND fa.user1_id is null ");
		}

		if (hdr.getUser2_ID() > 0) {
			sql.append(" ADN fa.user2_id = ? ");
			paramsList.add(hdr.getUser2_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USER2_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_User2_NullReq())) {
			sql.append(" AND fa.user2_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USER2_NULLREQ_MustBeNull.equals(hdr.getChuBoe_User2_NullReq())) {
			sql.append(" AND fa.user2_id is null ");
		}

		if (hdr.getUserElement1_ID() > 0) {
			sql.append(" AND fa.userelement1_id = ? ");
			paramsList.add(hdr.getUserElement1_ID());
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USERELEM1_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_UserElem1_NullReq())) {
			sql.append(" AND fa.userelement1_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USERELEM1_NULLREQ_MustBeNull.equals(hdr.getChuBoe_UserElem1_NullReq())) {
			sql.append(" AND fa.userelement1_id is null ");
		}

		if (hdr.getUserElement2_ID() > 0) {
			sql.append(" AND fa.userelement2_id = ? ");
			paramsList.add(hdr.getUserElement2_ID());
		}

		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USERELEM2_NULLREQ_CanBeAnyNotNullValue.equals(hdr.getChuBoe_UserElem2_NullReq())) {
			sql.append(" AND fa.userelement2_id is not null ");
		}
		
		if (X_Chuboe_TrialBalance_Hdr.CHUBOE_USERELEM2_NULLREQ_MustBeNull.equals(hdr.getChuBoe_UserElem2_NullReq())) {
			sql.append(" AND fa.userelement2_id is null ");
		}

		if (hdr.getChuBoe_Ref_Org_ID() > 0) {
			sql.append(" AND fa.ad_org_id = ? ");
			paramsList.add(hdr.getChuBoe_Ref_Org_ID());
		}
		
		if (hdr.getChuBoe_AccountFrom_ID() > 0) {
			sql.append(" AND (ev.value)::text >= acctfrom.value ");
		}
		
		if (hdr.getChuBoe_AccountTo_ID() > 0) {
			sql.append(" AND (ev.value)::text <= acctto.value ");
		}
		
		if (hdr.getChuBoe_DateAcctFrom() != null) {
			sql.append(" AND  fa.dateacct >= ? ");
			paramsList.add(hdr.getChuBoe_DateAcctFrom());
		}
		
		if (hdr.getChuBoe_DateAcctTo() != null) {
			sql.append(" AND fa.dateacct <= ? ");
			paramsList.add(hdr.getChuBoe_DateAcctTo());
		}
		
		int no = DB.executeUpdateEx(sql.toString(), paramsList.toArray(), get_TrxName());
		log.info("Inserted records: " + no);
		return "@OK@";
	}

}
