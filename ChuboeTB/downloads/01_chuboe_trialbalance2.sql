--------------------------------
-- Table to hold result details
--------------------------------
CREATE TABLE if not exists chuboe_trialbalance_detail (
    fact_acct_id numeric(10,0),
    ad_client_id numeric(10,0),
    ad_org_id numeric(10,0),
    isactive character(1),
    created timestamp without time zone,
    createdby numeric(10,0),
    updated timestamp without time zone,
    updatedby numeric(10,0),
    c_acctschema_id numeric(10,0),
    account_id numeric(10,0),
    datetrx timestamp without time zone,
    dateacct timestamp without time zone,
    c_period_id numeric(10,0),
    ad_table_id numeric(10,0),
    record_id numeric(10,0),
    line_id numeric(10,0),
    gl_category_id numeric(10,0),
    gl_budget_id numeric(10,0),
    c_tax_id numeric(10,0),
    m_locator_id numeric(10,0),
    postingtype character(1),
    c_currency_id numeric(10,0),
    amtsourcedr numeric,
    amtsourcecr numeric,
    amtacctdr numeric,
    amtacctcr numeric,
    c_uom_id numeric(10,0),
    qty numeric,
    m_product_id numeric(10,0),
    c_bpartner_id numeric(10,0),
    ad_orgtrx_id numeric(10,0),
    c_locfrom_id numeric(10,0),
    c_locto_id numeric(10,0),
    c_salesregion_id numeric(10,0),
    c_project_id numeric(10,0),
    c_campaign_id numeric(10,0),
    c_activity_id numeric(10,0),
    user1_id numeric(10,0),
    user2_id numeric(10,0),
    description character varying(255),
    a_asset_id numeric(10,0),
    c_subacct_id numeric(10,0),
    userelement1_id numeric(10,0),
    userelement2_id numeric(10,0),
    c_projectphase_id numeric(10,0),
    c_projecttask_id numeric(10,0),
    chuboe_trialbalance_hdr_id numeric(10,0),
    chuboe_trialbalance_detail_v_id numeric(10,0),
    hdr_created timestamp without time zone,
    hdr_createdby numeric(10,0),
    hdr_updated timestamp without time zone,
    hdr_updatedby numeric(10,0),
    accounttype character(1),
    ad_pinstance_id numeric(10,0),
    ischuboecurrent character(1)
);


CREATE INDEX chuboe_trialbalance_detail_idx ON chuboe_trialbalance_detail USING btree (chuboe_trialbalance_hdr_id, ad_org_id, account_id);

------------------------------
-- Function to determine the beginning of a fiscal year
------------------------------
CREATE OR REPLACE FUNCTION ChuBoe_fiscalstartdate(p_calendar_id numeric, p_acctdate timestamp without time zone)
  RETURNS timestamp without time zone AS
$BODY$DECLARE
	v_year_id		numeric :=0;
	v_startDate		timestamp without time zone := null;
BEGIN

SELECT min(startdate) into v_startDate
FROM C_Period
where C_Year_ID in
(
SELECT p.c_year_id
FROM C_Period p
JOIN C_Year y on (p.c_year_id = y.c_year_id)
WHERE y.c_calendar_id = p_calendar_id
 AND p_acctdate BETWEEN TRUNC(p.StartDate) AND TRUNC(p.EndDate)
 AND p.IsActive='Y' 
 AND p.PeriodType='S'
)
;

RETURN	v_startDate;
END;	$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

------------------------------
-- view to use the parameters from the trial balance header to pull the approprate Fact_Acct (GL) records.
------------------------------
CREATE or replace VIEW ChuBoe_trialbalance_detail_v AS
    SELECT fact_acct_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_acctschema_id, account_id, datetrx, dateacct, c_period_id, ad_table_id, record_id, line_id, gl_category_id, gl_budget_id, c_tax_id, m_locator_id, postingtype, c_currency_id, amtsourcedr, amtsourcecr, amtacctdr, amtacctcr, c_uom_id, qty, m_product_id, c_bpartner_id, ad_orgtrx_id, c_locfrom_id, c_locto_id, c_salesregion_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, description, a_asset_id, c_subacct_id, userelement1_id, userelement2_id, c_projectphase_id, c_projecttask_id, ChuBoe_trialbalance_hdr_id, ChuBoe_trialbalance_detail_v_id, hdr_created, hdr_createdby, hdr_updated, hdr_updatedby, accounttype, ischuboecurrent 
FROM chuboe_trialbalance_detail
;

------------------------------
-- view to summarize the above detail records.
------------------------------

CREATE or replace VIEW ChuBoe_trialbalance_sum_v AS
    SELECT fa.ad_client_id, fa.ad_org_id, fa.c_acctschema_id, fa.account_id, fa.postingtype, fa.hdr_created AS created, fa.hdr_createdby AS createdby, fa.hdr_updated AS updated, fa.hdr_updatedby AS updatedby, sum(fa.amtsourcedr) AS amtsourcedr, sum(fa.amtsourcecr) AS amtsourcecr, sum((fa.amtsourcedr - fa.amtsourcecr)) AS amtsource, sum(fa.amtacctdr) AS amtacctdr, sum(fa.amtacctcr) AS amtacctcr, sum((fa.amtacctdr - fa.amtacctcr)) AS amtacct, fa.ChuBoe_trialbalance_hdr_id, fa.ischuboecurrent 
FROM ChuBoe_trialbalance_detail fa 
GROUP BY fa.ad_client_id, fa.ad_org_id, fa.c_acctschema_id, fa.account_id, fa.postingtype, fa.ChuBoe_trialbalance_hdr_id, fa.hdr_created, fa.hdr_createdby, fa.hdr_updated, fa.hdr_updatedby, fa.ischuboecurrent;

--here
Create or replace view chuboe_trialbalance_rsum_by_period_v as
 SELECT fa.ad_client_id,
    fa.ad_org_id,
    fa.c_acctschema_id,
    fa.account_id,
    p.c_period_id,
    fa.postingtype,
    fa.hdr_created AS created,
    fa.hdr_createdby AS createdby,
    fa.hdr_updated AS updated,
    fa.hdr_updatedby AS updatedby,
    sum(fa.amtsourcedr) AS amtsourcedr,
    sum(fa.amtsourcecr) AS amtsourcecr,
    sum(fa.amtsourcedr - fa.amtsourcecr) AS amtsource,
    sum(fa.amtacctdr) AS amtacctdr,
    sum(fa.amtacctcr) AS amtacctcr,
    sum(fa.amtacctdr - fa.amtacctcr) AS amtacct,
    fa.chuboe_trialbalance_hdr_id,
    p.enddate,
    ( SELECT sum(fax.amtsourcedr) AS sum
           FROM chuboe_trialbalance_detail_v fax
          WHERE fax.chuboe_trialbalance_hdr_id = fa.chuboe_trialbalance_hdr_id AND fax.ad_org_id = fa.ad_org_id AND fax.c_acctschema_id = fa.c_acctschema_id AND fax.account_id = fa.account_id AND fax.postingtype = fa.postingtype AND fax.dateacct <= p.enddate AND fax.dateacct >=
                CASE
                    WHEN fa.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar]) THEN to_timestamp(0::double precision)
                    ELSE chuboe_fiscalstartdate(cal.c_calendar_id, p.enddate)::timestamp with time zone
                END) AS chuboe_amtsourcedr_rtotal,
    ( SELECT sum(fax.amtsourcecr) AS sum
           FROM chuboe_trialbalance_detail_v fax
          WHERE fax.chuboe_trialbalance_hdr_id = fa.chuboe_trialbalance_hdr_id AND fax.ad_org_id = fa.ad_org_id AND fax.c_acctschema_id = fa.c_acctschema_id AND fax.account_id = fa.account_id AND fax.postingtype = fa.postingtype AND fax.dateacct <= p.enddate AND fax.dateacct >=
                CASE
                    WHEN fa.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar]) THEN to_timestamp(0::double precision)
                    ELSE chuboe_fiscalstartdate(cal.c_calendar_id, p.enddate)::timestamp with time zone
                END) AS chuboe_amtsourcecr_rtotal,
    ( SELECT sum(fax.amtsourcedr - fax.amtsourcecr) AS sum
           FROM chuboe_trialbalance_detail_v fax
          WHERE fax.chuboe_trialbalance_hdr_id = fa.chuboe_trialbalance_hdr_id AND fax.ad_org_id = fa.ad_org_id AND fax.c_acctschema_id = fa.c_acctschema_id AND fax.account_id = fa.account_id AND fax.postingtype = fa.postingtype AND fax.dateacct <= p.enddate AND fax.dateacct >=
                CASE
                    WHEN fa.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar]) THEN to_timestamp(0::double precision)
                    ELSE chuboe_fiscalstartdate(cal.c_calendar_id, p.enddate)::timestamp with time zone
                END) AS chuboe_amtsource_rtotal,
    ( SELECT sum(fax.amtacctdr) AS sum
           FROM chuboe_trialbalance_detail_v fax
          WHERE fax.chuboe_trialbalance_hdr_id = fa.chuboe_trialbalance_hdr_id AND fax.ad_org_id = fa.ad_org_id AND fax.c_acctschema_id = fa.c_acctschema_id AND fax.account_id = fa.account_id AND fax.postingtype = fa.postingtype AND fax.dateacct <= p.enddate AND fax.dateacct >=
                CASE
                    WHEN fa.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar]) THEN to_timestamp(0::double precision)
                    ELSE chuboe_fiscalstartdate(cal.c_calendar_id, p.enddate)::timestamp with time zone
                END) AS chuboe_amtacctdr_rtotal,
    ( SELECT sum(fax.amtacctcr) AS sum
           FROM chuboe_trialbalance_detail_v fax
          WHERE fax.chuboe_trialbalance_hdr_id = fa.chuboe_trialbalance_hdr_id AND fax.ad_org_id = fa.ad_org_id AND fax.c_acctschema_id = fa.c_acctschema_id AND fax.account_id = fa.account_id AND fax.postingtype = fa.postingtype AND fax.dateacct <= p.enddate AND fax.dateacct >=
                CASE
                    WHEN fa.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar]) THEN to_timestamp(0::double precision)
                    ELSE chuboe_fiscalstartdate(cal.c_calendar_id, p.enddate)::timestamp with time zone
                END) AS chuboe_amtacctcr_rtotal,
    ( SELECT sum(fax.amtacctdr - fax.amtacctcr) AS sum
           FROM chuboe_trialbalance_detail_v fax
          WHERE fax.chuboe_trialbalance_hdr_id = fa.chuboe_trialbalance_hdr_id AND fax.ad_org_id = fa.ad_org_id AND fax.c_acctschema_id = fa.c_acctschema_id AND fax.account_id = fa.account_id AND fax.postingtype = fa.postingtype AND fax.dateacct <= p.enddate AND fax.dateacct >=
                CASE
                    WHEN fa.accounttype = ANY (ARRAY['A'::bpchar, 'L'::bpchar, 'O'::bpchar]) THEN to_timestamp(0::double precision)
                    ELSE chuboe_fiscalstartdate(cal.c_calendar_id, p.enddate)::timestamp with time zone
                END) AS chuboe_amtacct_rtotal,
    cal.c_calendar_id
   FROM chuboe_trialbalance_detail_v fa
     JOIN c_period p ON fa.dateacct >= p.startdate AND fa.dateacct <= p.enddate AND fa.ad_client_id = p.ad_client_id
     JOIN c_year y ON p.c_year_id = y.c_year_id
     JOIN c_calendar cal ON y.c_calendar_id = cal.c_calendar_id
  GROUP BY fa.ad_client_id, fa.ad_org_id, fa.c_acctschema_id, fa.account_id, fa.accounttype, p.c_period_id, p.enddate, fa.postingtype, fa.chuboe_trialbalance_hdr_id, fa.hdr_created, fa.hdr_createdby, fa.hdr_updated, fa.hdr_updatedby, cal.c_calendar_id;

Create or replace view chuboe_trialbalance_sum_bp_v as
SELECT fa.ad_client_id,
    fa.ad_org_id,
    fa.c_acctschema_id,
    fa.account_id,
    fa.postingtype,
    fa.hdr_created AS created,
    fa.hdr_createdby AS createdby,
    fa.hdr_updated AS updated,
    fa.hdr_updatedby AS updatedby,
    sum(fa.amtsourcedr) AS amtsourcedr,
    sum(fa.amtsourcecr) AS amtsourcecr,
    sum(fa.amtsourcedr - fa.amtsourcecr) AS amtsource,
    sum(fa.amtacctdr) AS amtacctdr,
    sum(fa.amtacctcr) AS amtacctcr,
    sum(fa.amtacctdr - fa.amtacctcr) AS amtacct,
    fa.chuboe_trialbalance_hdr_id,
    fa.ischuboecurrent,
    fa.c_bpartner_id
   FROM chuboe_trialbalance_detail fa
  GROUP BY fa.ad_client_id, fa.ad_org_id, fa.c_acctschema_id, fa.account_id, fa.postingtype, fa.chuboe_trialbalance_hdr_id, fa.hdr_created, fa.hdr_createdby, fa.hdr_updated, fa.hdr_updatedby, fa.ischuboecurrent, fa.c_bpartner_id;

Create or replace view chuboe_trialbalance_sum_prod_v as
SELECT fa.ad_client_id,
    fa.ad_org_id,
    fa.c_acctschema_id,
    fa.account_id,
    fa.postingtype,
    fa.hdr_created AS created,
    fa.hdr_createdby AS createdby,
    fa.hdr_updated AS updated,
    fa.hdr_updatedby AS updatedby,
    sum(fa.amtsourcedr) AS amtsourcedr,
    sum(fa.amtsourcecr) AS amtsourcecr,
    sum(fa.amtsourcedr - fa.amtsourcecr) AS amtsource,
    sum(fa.amtacctdr) AS amtacctdr,
    sum(fa.amtacctcr) AS amtacctcr,
    sum(fa.amtacctdr - fa.amtacctcr) AS amtacct,
    fa.chuboe_trialbalance_hdr_id,
    fa.ischuboecurrent,
    fa.m_product_id
   FROM chuboe_trialbalance_detail fa
  GROUP BY fa.ad_client_id, fa.ad_org_id, fa.c_acctschema_id, fa.account_id, fa.postingtype, fa.chuboe_trialbalance_hdr_id, fa.hdr_created, fa.hdr_createdby, fa.hdr_updated, fa.hdr_updatedby, fa.ischuboecurrent, fa.m_product_id;

Create or replace view chuboe_trialbalance_sum_proj_v as
SELECT fa.ad_client_id,
    fa.ad_org_id,
    fa.c_acctschema_id,
    fa.account_id,
    fa.postingtype,
    fa.hdr_created AS created,
    fa.hdr_createdby AS createdby,
    fa.hdr_updated AS updated,
    fa.hdr_updatedby AS updatedby,
    sum(fa.amtsourcedr) AS amtsourcedr,
    sum(fa.amtsourcecr) AS amtsourcecr,
    sum(fa.amtsourcedr - fa.amtsourcecr) AS amtsource,
    sum(fa.amtacctdr) AS amtacctdr,
    sum(fa.amtacctcr) AS amtacctcr,
    sum(fa.amtacctdr - fa.amtacctcr) AS amtacct,
    fa.chuboe_trialbalance_hdr_id,
    fa.ischuboecurrent,
    fa.c_project_id
   FROM chuboe_trialbalance_detail fa
  GROUP BY fa.ad_client_id, fa.ad_org_id, fa.c_acctschema_id, fa.account_id, fa.postingtype, fa.chuboe_trialbalance_hdr_id, fa.hdr_created, fa.hdr_createdby, fa.hdr_updated, fa.hdr_updatedby, fa.ischuboecurrent, fa.c_project_id;


--unfortunately iDempiere supports Oracle and Oracle does not like readable column names.
--foturnately, postgresql is better and it allows column names to be a readable length.
--the below statements update the columnname fields to be 40.

update AD_Column 
set fieldlength=40
WHERE AD_Column_UU in
('67bb6666-3a73-4886-ac95-98d069bff819',
'7ac4622e-b6a3-4749-a104-3ffbefcda0e0',
'ec40ecf8-3ddf-4ae3-82d8-1bc36cede639',
'37671430-92ad-423a-9ce1-f3fb147e0ad6',
'07a7935b-2a59-48e3-a80a-f11b785afed3',
'30db973a-b039-437e-b55a-c9ca1e9d7378',
'14ce970a-593a-4263-aa73-623d207133fd'
)
;

select altercolumn('ad_element', 'columnname', 'character varying (40)',null, null);
select altercolumn('ad_column', 'columnname', 'character varying (40)',null, null);
select altercolumn('AD_Process_Para', 'columnname', 'character varying (40)',null, null);
select altercolumn('A_RegistrationAttribute', 'columnname', 'character varying (40)',null, null);
select altercolumn('AD_InfoColumn', 'columnname', 'character varying (40)',null, null);
select altercolumn('WS_WebServiceFieldInput', 'columnname', 'character varying (40)',null, null);
select altercolumn('AD_ViewColumn', 'columnname', 'character varying (40)',null, null);

