/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.chuboe.trialbalance2.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for Chuboe_TrialBalance_Hdr
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_Chuboe_TrialBalance_Hdr extends PO implements I_Chuboe_TrialBalance_Hdr, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20161013L;

    /** Standard Constructor */
    public X_Chuboe_TrialBalance_Hdr (Properties ctx, int Chuboe_TrialBalance_Hdr_ID, String trxName)
    {
      super (ctx, Chuboe_TrialBalance_Hdr_ID, trxName);
      /** if (Chuboe_TrialBalance_Hdr_ID == 0)
        {
			setC_AcctSchema_ID (0);
			setC_Calendar_ID (0);
			setChuBoe_DateAcctTo (new Timestamp( System.currentTimeMillis() ));
			setChuboe_TrialBalance_Hdr_ID (0);
			setPostingType (null);
// A
        } */
    }

    /** Load Constructor */
    public X_Chuboe_TrialBalance_Hdr (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_Chuboe_TrialBalance_Hdr[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Trx Organization.
		@param AD_OrgTrx_ID 
		Performing or initiating organization
	  */
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID)
	{
		if (AD_OrgTrx_ID < 1) 
			set_Value (COLUMNNAME_AD_OrgTrx_ID, null);
		else 
			set_Value (COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
	}

	/** Get Trx Organization.
		@return Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgTrx_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_PInstance getAD_PInstance() throws RuntimeException
    {
		return (org.compiere.model.I_AD_PInstance)MTable.get(getCtx(), org.compiere.model.I_AD_PInstance.Table_Name)
			.getPO(getAD_PInstance_ID(), get_TrxName());	}

	/** Set Process Instance.
		@param AD_PInstance_ID 
		Instance of the process
	  */
	public void setAD_PInstance_ID (int AD_PInstance_ID)
	{
		if (AD_PInstance_ID < 1) 
			set_Value (COLUMNNAME_AD_PInstance_ID, null);
		else 
			set_Value (COLUMNNAME_AD_PInstance_ID, Integer.valueOf(AD_PInstance_ID));
	}

	/** Get Process Instance.
		@return Instance of the process
	  */
	public int getAD_PInstance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_PInstance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_AcctSchema getC_AcctSchema() throws RuntimeException
    {
		return (org.compiere.model.I_C_AcctSchema)MTable.get(getCtx(), org.compiere.model.I_C_AcctSchema.Table_Name)
			.getPO(getC_AcctSchema_ID(), get_TrxName());	}

	/** Set Accounting Schema.
		@param C_AcctSchema_ID 
		Rules for accounting
	  */
	public void setC_AcctSchema_ID (int C_AcctSchema_ID)
	{
		if (C_AcctSchema_ID < 1) 
			set_Value (COLUMNNAME_C_AcctSchema_ID, null);
		else 
			set_Value (COLUMNNAME_C_AcctSchema_ID, Integer.valueOf(C_AcctSchema_ID));
	}

	/** Get Accounting Schema.
		@return Rules for accounting
	  */
	public int getC_AcctSchema_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_AcctSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
    {
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
			.getPO(getC_Activity_ID(), get_TrxName());	}

	/** Set Activity.
		@param C_Activity_ID 
		Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1) 
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else 
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Calendar getC_Calendar() throws RuntimeException
    {
		return (org.compiere.model.I_C_Calendar)MTable.get(getCtx(), org.compiere.model.I_C_Calendar.Table_Name)
			.getPO(getC_Calendar_ID(), get_TrxName());	}

	/** Set Calendar.
		@param C_Calendar_ID 
		Accounting Calendar Name
	  */
	public void setC_Calendar_ID (int C_Calendar_ID)
	{
		if (C_Calendar_ID < 1) 
			set_Value (COLUMNNAME_C_Calendar_ID, null);
		else 
			set_Value (COLUMNNAME_C_Calendar_ID, Integer.valueOf(C_Calendar_ID));
	}

	/** Get Calendar.
		@return Accounting Calendar Name
	  */
	public int getC_Calendar_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Calendar_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException
    {
		return (org.compiere.model.I_C_Campaign)MTable.get(getCtx(), org.compiere.model.I_C_Campaign.Table_Name)
			.getPO(getC_Campaign_ID(), get_TrxName());	}

	/** Set Campaign.
		@param C_Campaign_ID 
		Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID)
	{
		if (C_Campaign_ID < 1) 
			set_Value (COLUMNNAME_C_Campaign_ID, null);
		else 
			set_Value (COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
	}

	/** Get Campaign.
		@return Marketing Campaign
	  */
	public int getC_Campaign_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Campaign_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getChuBoe_AccountFrom() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getChuBoe_AccountFrom_ID(), get_TrxName());	}

	/** Set Account From.
		@param ChuBoe_AccountFrom_ID Account From	  */
	public void setChuBoe_AccountFrom_ID (int ChuBoe_AccountFrom_ID)
	{
		if (ChuBoe_AccountFrom_ID < 1) 
			set_Value (COLUMNNAME_ChuBoe_AccountFrom_ID, null);
		else 
			set_Value (COLUMNNAME_ChuBoe_AccountFrom_ID, Integer.valueOf(ChuBoe_AccountFrom_ID));
	}

	/** Get Account From.
		@return Account From	  */
	public int getChuBoe_AccountFrom_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ChuBoe_AccountFrom_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getChuBoe_AccountTo() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getChuBoe_AccountTo_ID(), get_TrxName());	}

	/** Set Account To.
		@param ChuBoe_AccountTo_ID Account To	  */
	public void setChuBoe_AccountTo_ID (int ChuBoe_AccountTo_ID)
	{
		if (ChuBoe_AccountTo_ID < 1) 
			set_Value (COLUMNNAME_ChuBoe_AccountTo_ID, null);
		else 
			set_Value (COLUMNNAME_ChuBoe_AccountTo_ID, Integer.valueOf(ChuBoe_AccountTo_ID));
	}

	/** Get Account To.
		@return Account To	  */
	public int getChuBoe_AccountTo_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ChuBoe_AccountTo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_ACTIVITY_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_ACTIVITY_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_Activity_NullReq Null Requirement	  */
	public void setChuBoe_Activity_NullReq (String ChuBoe_Activity_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_Activity_NullReq, ChuBoe_Activity_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_Activity_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_Activity_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_BP_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_BP_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_BP_NullReq Null Requirement	  */
	public void setChuBoe_BP_NullReq (String ChuBoe_BP_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_BP_NullReq, ChuBoe_BP_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_BP_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_BP_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_CAMPAIGN_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_CAMPAIGN_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_Campaign_NullReq Null Requirement	  */
	public void setChuBoe_Campaign_NullReq (String ChuBoe_Campaign_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_Campaign_NullReq, ChuBoe_Campaign_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_Campaign_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_Campaign_NullReq);
	}

	/** Set Create Trial Balance Detail Records.
		@param ChuBoe_Create_TB_Details Create Trial Balance Detail Records	  */
	public void setChuBoe_Create_TB_Details (String ChuBoe_Create_TB_Details)
	{
		set_Value (COLUMNNAME_ChuBoe_Create_TB_Details, ChuBoe_Create_TB_Details);
	}

	/** Get Create Trial Balance Detail Records.
		@return Create Trial Balance Detail Records	  */
	public String getChuBoe_Create_TB_Details () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_Create_TB_Details);
	}

	/** Set Date From.
		@param ChuBoe_DateAcctFrom Date From	  */
	public void setChuBoe_DateAcctFrom (Timestamp ChuBoe_DateAcctFrom)
	{
		set_Value (COLUMNNAME_ChuBoe_DateAcctFrom, ChuBoe_DateAcctFrom);
	}

	/** Get Date From.
		@return Date From	  */
	public Timestamp getChuBoe_DateAcctFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ChuBoe_DateAcctFrom);
	}

	/** Set Date To.
		@param ChuBoe_DateAcctTo Date To	  */
	public void setChuBoe_DateAcctTo (Timestamp ChuBoe_DateAcctTo)
	{
		set_Value (COLUMNNAME_ChuBoe_DateAcctTo, ChuBoe_DateAcctTo);
	}

	/** Get Date To.
		@return Date To	  */
	public Timestamp getChuBoe_DateAcctTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ChuBoe_DateAcctTo);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_ORGTRX_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_ORGTRX_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_OrgTrx_NullReq Null Requirement	  */
	public void setChuBoe_OrgTrx_NullReq (String ChuBoe_OrgTrx_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_OrgTrx_NullReq, ChuBoe_OrgTrx_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_OrgTrx_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_OrgTrx_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_PRODUCT_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_PRODUCT_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_Product_NullReq Null Requirement	  */
	public void setChuBoe_Product_NullReq (String ChuBoe_Product_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_Product_NullReq, ChuBoe_Product_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_Product_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_Product_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_PROJECT_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_PROJECT_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_Project_NullReq Null Requirement	  */
	public void setChuBoe_Project_NullReq (String ChuBoe_Project_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_Project_NullReq, ChuBoe_Project_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_Project_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_Project_NullReq);
	}

	/** Set Search Org.
		@param ChuBoe_Ref_Org_ID Search Org	  */
	public void setChuBoe_Ref_Org_ID (int ChuBoe_Ref_Org_ID)
	{
		if (ChuBoe_Ref_Org_ID < 1) 
			set_Value (COLUMNNAME_ChuBoe_Ref_Org_ID, null);
		else 
			set_Value (COLUMNNAME_ChuBoe_Ref_Org_ID, Integer.valueOf(ChuBoe_Ref_Org_ID));
	}

	/** Get Search Org.
		@return Search Org	  */
	public int getChuBoe_Ref_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ChuBoe_Ref_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Currency getChuBoe_TB_Currency() throws RuntimeException
    {
		return (org.compiere.model.I_C_Currency)MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
			.getPO(getChuBoe_TB_Currency_ID(), get_TrxName());	}

	/** Set Currency.
		@param ChuBoe_TB_Currency_ID Currency	  */
	public void setChuBoe_TB_Currency_ID (int ChuBoe_TB_Currency_ID)
	{
		if (ChuBoe_TB_Currency_ID < 1) 
			set_Value (COLUMNNAME_ChuBoe_TB_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_ChuBoe_TB_Currency_ID, Integer.valueOf(ChuBoe_TB_Currency_ID));
	}

	/** Get Currency.
		@return Currency	  */
	public int getChuBoe_TB_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ChuBoe_TB_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Chuboe_TrialBalance_Hdr.
		@param Chuboe_TrialBalance_Hdr_ID Chuboe_TrialBalance_Hdr	  */
	public void setChuboe_TrialBalance_Hdr_ID (int Chuboe_TrialBalance_Hdr_ID)
	{
		if (Chuboe_TrialBalance_Hdr_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Chuboe_TrialBalance_Hdr_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Chuboe_TrialBalance_Hdr_ID, Integer.valueOf(Chuboe_TrialBalance_Hdr_ID));
	}

	/** Get Chuboe_TrialBalance_Hdr.
		@return Chuboe_TrialBalance_Hdr	  */
	public int getChuboe_TrialBalance_Hdr_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Chuboe_TrialBalance_Hdr_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_USER1_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_USER1_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_User1_NullReq Null Requirement	  */
	public void setChuBoe_User1_NullReq (String ChuBoe_User1_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_User1_NullReq, ChuBoe_User1_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_User1_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_User1_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_USER2_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_USER2_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_User2_NullReq Null Requirement	  */
	public void setChuBoe_User2_NullReq (String ChuBoe_User2_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_User2_NullReq, ChuBoe_User2_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_User2_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_User2_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_USERELEM1_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_USERELEM1_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_UserElem1_NullReq Null Requirement	  */
	public void setChuBoe_UserElem1_NullReq (String ChuBoe_UserElem1_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_UserElem1_NullReq, ChuBoe_UserElem1_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_UserElem1_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_UserElem1_NullReq);
	}

	/** Can be any not null value = NotNull */
	public static final String CHUBOE_USERELEM2_NULLREQ_CanBeAnyNotNullValue = "NotNull";
	/** Must be null = IsNull */
	public static final String CHUBOE_USERELEM2_NULLREQ_MustBeNull = "IsNull";
	/** Set Null Requirement.
		@param ChuBoe_UserElem2_NullReq Null Requirement	  */
	public void setChuBoe_UserElem2_NullReq (String ChuBoe_UserElem2_NullReq)
	{

		set_Value (COLUMNNAME_ChuBoe_UserElem2_NullReq, ChuBoe_UserElem2_NullReq);
	}

	/** Get Null Requirement.
		@return Null Requirement	  */
	public String getChuBoe_UserElem2_NullReq () 
	{
		return (String)get_Value(COLUMNNAME_ChuBoe_UserElem2_NullReq);
	}

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_Value (COLUMNNAME_C_Project_ID, null);
		else 
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** PostingType AD_Reference_ID=125 */
	public static final int POSTINGTYPE_AD_Reference_ID=125;
	/** Actual = A */
	public static final String POSTINGTYPE_Actual = "A";
	/** Budget = B */
	public static final String POSTINGTYPE_Budget = "B";
	/** Commitment = E */
	public static final String POSTINGTYPE_Commitment = "E";
	/** Statistical = S */
	public static final String POSTINGTYPE_Statistical = "S";
	/** Reservation = R */
	public static final String POSTINGTYPE_Reservation = "R";
	/** Set PostingType.
		@param PostingType 
		The type of posted amount for the transaction
	  */
	public void setPostingType (String PostingType)
	{

		set_Value (COLUMNNAME_PostingType, PostingType);
	}

	/** Get PostingType.
		@return The type of posted amount for the transaction
	  */
	public String getPostingType () 
	{
		return (String)get_Value(COLUMNNAME_PostingType);
	}

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser1_ID(), get_TrxName());	}

	/** Set User Element List 1.
		@param User1_ID 
		User defined list element #1
	  */
	public void setUser1_ID (int User1_ID)
	{
		if (User1_ID < 1) 
			set_Value (COLUMNNAME_User1_ID, null);
		else 
			set_Value (COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
	}

	/** Get User Element List 1.
		@return User defined list element #1
	  */
	public int getUser1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser2() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser2_ID(), get_TrxName());	}

	/** Set User Element List 2.
		@param User2_ID 
		User defined list element #2
	  */
	public void setUser2_ID (int User2_ID)
	{
		if (User2_ID < 1) 
			set_Value (COLUMNNAME_User2_ID, null);
		else 
			set_Value (COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
	}

	/** Get User Element List 2.
		@return User defined list element #2
	  */
	public int getUser2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Shipper getUserElement1() throws RuntimeException
    {
		return (org.compiere.model.I_M_Shipper)MTable.get(getCtx(), org.compiere.model.I_M_Shipper.Table_Name)
			.getPO(getUserElement1_ID(), get_TrxName());	}

	/** Set User Column 1.
		@param UserElement1_ID 
		User defined accounting Element
	  */
	public void setUserElement1_ID (int UserElement1_ID)
	{
		if (UserElement1_ID < 1) 
			set_Value (COLUMNNAME_UserElement1_ID, null);
		else 
			set_Value (COLUMNNAME_UserElement1_ID, Integer.valueOf(UserElement1_ID));
	}

	/** Get User Column 1.
		@return User defined accounting Element
	  */
	public int getUserElement1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_UserElement1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Shipper getUserElement2() throws RuntimeException
    {
		return (org.compiere.model.I_M_Shipper)MTable.get(getCtx(), org.compiere.model.I_M_Shipper.Table_Name)
			.getPO(getUserElement2_ID(), get_TrxName());	}

	/** Set User Column 2.
		@param UserElement2_ID 
		User defined accounting Element
	  */
	public void setUserElement2_ID (int UserElement2_ID)
	{
		if (UserElement2_ID < 1) 
			set_Value (COLUMNNAME_UserElement2_ID, null);
		else 
			set_Value (COLUMNNAME_UserElement2_ID, Integer.valueOf(UserElement2_ID));
	}

	/** Get User Column 2.
		@return User defined accounting Element
	  */
	public int getUserElement2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_UserElement2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}