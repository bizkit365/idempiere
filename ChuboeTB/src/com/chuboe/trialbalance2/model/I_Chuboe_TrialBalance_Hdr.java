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
package com.chuboe.trialbalance2.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for Chuboe_TrialBalance_Hdr
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_Chuboe_TrialBalance_Hdr 
{

    /** TableName=Chuboe_TrialBalance_Hdr */
    public static final String Table_Name = "Chuboe_TrialBalance_Hdr";

    /** AD_Table_ID=1000000 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_OrgTrx_ID */
    public static final String COLUMNNAME_AD_OrgTrx_ID = "AD_OrgTrx_ID";

	/** Set Trx Organization.
	  * Performing or initiating organization
	  */
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID);

	/** Get Trx Organization.
	  * Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID();

    /** Column name AD_PInstance_ID */
    public static final String COLUMNNAME_AD_PInstance_ID = "AD_PInstance_ID";

	/** Set Process Instance.
	  * Instance of the process
	  */
	public void setAD_PInstance_ID (int AD_PInstance_ID);

	/** Get Process Instance.
	  * Instance of the process
	  */
	public int getAD_PInstance_ID();

	public org.compiere.model.I_AD_PInstance getAD_PInstance() throws RuntimeException;

    /** Column name C_AcctSchema_ID */
    public static final String COLUMNNAME_C_AcctSchema_ID = "C_AcctSchema_ID";

	/** Set Accounting Schema.
	  * Rules for accounting
	  */
	public void setC_AcctSchema_ID (int C_AcctSchema_ID);

	/** Get Accounting Schema.
	  * Rules for accounting
	  */
	public int getC_AcctSchema_ID();

	public org.compiere.model.I_C_AcctSchema getC_AcctSchema() throws RuntimeException;

    /** Column name C_Activity_ID */
    public static final String COLUMNNAME_C_Activity_ID = "C_Activity_ID";

	/** Set Activity.
	  * Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID);

	/** Get Activity.
	  * Business Activity
	  */
	public int getC_Activity_ID();

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException;

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_Calendar_ID */
    public static final String COLUMNNAME_C_Calendar_ID = "C_Calendar_ID";

	/** Set Calendar.
	  * Accounting Calendar Name
	  */
	public void setC_Calendar_ID (int C_Calendar_ID);

	/** Get Calendar.
	  * Accounting Calendar Name
	  */
	public int getC_Calendar_ID();

	public org.compiere.model.I_C_Calendar getC_Calendar() throws RuntimeException;

    /** Column name C_Campaign_ID */
    public static final String COLUMNNAME_C_Campaign_ID = "C_Campaign_ID";

	/** Set Campaign.
	  * Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID);

	/** Get Campaign.
	  * Marketing Campaign
	  */
	public int getC_Campaign_ID();

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException;

    /** Column name ChuBoe_AccountFrom_ID */
    public static final String COLUMNNAME_ChuBoe_AccountFrom_ID = "ChuBoe_AccountFrom_ID";

	/** Set Account From	  */
	public void setChuBoe_AccountFrom_ID (int ChuBoe_AccountFrom_ID);

	/** Get Account From	  */
	public int getChuBoe_AccountFrom_ID();

	public org.compiere.model.I_C_ElementValue getChuBoe_AccountFrom() throws RuntimeException;

    /** Column name ChuBoe_AccountTo_ID */
    public static final String COLUMNNAME_ChuBoe_AccountTo_ID = "ChuBoe_AccountTo_ID";

	/** Set Account To	  */
	public void setChuBoe_AccountTo_ID (int ChuBoe_AccountTo_ID);

	/** Get Account To	  */
	public int getChuBoe_AccountTo_ID();

	public org.compiere.model.I_C_ElementValue getChuBoe_AccountTo() throws RuntimeException;

    /** Column name ChuBoe_Activity_NullReq */
    public static final String COLUMNNAME_ChuBoe_Activity_NullReq = "ChuBoe_Activity_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_Activity_NullReq (String ChuBoe_Activity_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_Activity_NullReq();

    /** Column name ChuBoe_BP_NullReq */
    public static final String COLUMNNAME_ChuBoe_BP_NullReq = "ChuBoe_BP_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_BP_NullReq (String ChuBoe_BP_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_BP_NullReq();

    /** Column name ChuBoe_Campaign_NullReq */
    public static final String COLUMNNAME_ChuBoe_Campaign_NullReq = "ChuBoe_Campaign_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_Campaign_NullReq (String ChuBoe_Campaign_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_Campaign_NullReq();

    /** Column name ChuBoe_Create_TB_Details */
    public static final String COLUMNNAME_ChuBoe_Create_TB_Details = "ChuBoe_Create_TB_Details";

	/** Set Create Trial Balance Detail Records	  */
	public void setChuBoe_Create_TB_Details (String ChuBoe_Create_TB_Details);

	/** Get Create Trial Balance Detail Records	  */
	public String getChuBoe_Create_TB_Details();

    /** Column name ChuBoe_DateAcctFrom */
    public static final String COLUMNNAME_ChuBoe_DateAcctFrom = "ChuBoe_DateAcctFrom";

	/** Set Date From	  */
	public void setChuBoe_DateAcctFrom (Timestamp ChuBoe_DateAcctFrom);

	/** Get Date From	  */
	public Timestamp getChuBoe_DateAcctFrom();

    /** Column name ChuBoe_DateAcctTo */
    public static final String COLUMNNAME_ChuBoe_DateAcctTo = "ChuBoe_DateAcctTo";

	/** Set Date To	  */
	public void setChuBoe_DateAcctTo (Timestamp ChuBoe_DateAcctTo);

	/** Get Date To	  */
	public Timestamp getChuBoe_DateAcctTo();

    /** Column name ChuBoe_OrgTrx_NullReq */
    public static final String COLUMNNAME_ChuBoe_OrgTrx_NullReq = "ChuBoe_OrgTrx_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_OrgTrx_NullReq (String ChuBoe_OrgTrx_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_OrgTrx_NullReq();

    /** Column name ChuBoe_Product_NullReq */
    public static final String COLUMNNAME_ChuBoe_Product_NullReq = "ChuBoe_Product_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_Product_NullReq (String ChuBoe_Product_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_Product_NullReq();

    /** Column name ChuBoe_Project_NullReq */
    public static final String COLUMNNAME_ChuBoe_Project_NullReq = "ChuBoe_Project_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_Project_NullReq (String ChuBoe_Project_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_Project_NullReq();

    /** Column name ChuBoe_Ref_Org_ID */
    public static final String COLUMNNAME_ChuBoe_Ref_Org_ID = "ChuBoe_Ref_Org_ID";

	/** Set Search Org	  */
	public void setChuBoe_Ref_Org_ID (int ChuBoe_Ref_Org_ID);

	/** Get Search Org	  */
	public int getChuBoe_Ref_Org_ID();

    /** Column name ChuBoe_TB_Currency_ID */
    public static final String COLUMNNAME_ChuBoe_TB_Currency_ID = "ChuBoe_TB_Currency_ID";

	/** Set Currency	  */
	public void setChuBoe_TB_Currency_ID (int ChuBoe_TB_Currency_ID);

	/** Get Currency	  */
	public int getChuBoe_TB_Currency_ID();

	public org.compiere.model.I_C_Currency getChuBoe_TB_Currency() throws RuntimeException;

    /** Column name Chuboe_TrialBalance_Hdr_ID */
    public static final String COLUMNNAME_Chuboe_TrialBalance_Hdr_ID = "Chuboe_TrialBalance_Hdr_ID";

	/** Set Chuboe_TrialBalance_Hdr	  */
	public void setChuboe_TrialBalance_Hdr_ID (int Chuboe_TrialBalance_Hdr_ID);

	/** Get Chuboe_TrialBalance_Hdr	  */
	public int getChuboe_TrialBalance_Hdr_ID();

    /** Column name ChuBoe_User1_NullReq */
    public static final String COLUMNNAME_ChuBoe_User1_NullReq = "ChuBoe_User1_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_User1_NullReq (String ChuBoe_User1_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_User1_NullReq();

    /** Column name ChuBoe_User2_NullReq */
    public static final String COLUMNNAME_ChuBoe_User2_NullReq = "ChuBoe_User2_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_User2_NullReq (String ChuBoe_User2_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_User2_NullReq();

    /** Column name ChuBoe_UserElem1_NullReq */
    public static final String COLUMNNAME_ChuBoe_UserElem1_NullReq = "ChuBoe_UserElem1_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_UserElem1_NullReq (String ChuBoe_UserElem1_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_UserElem1_NullReq();

    /** Column name ChuBoe_UserElem2_NullReq */
    public static final String COLUMNNAME_ChuBoe_UserElem2_NullReq = "ChuBoe_UserElem2_NullReq";

	/** Set Null Requirement	  */
	public void setChuBoe_UserElem2_NullReq (String ChuBoe_UserElem2_NullReq);

	/** Get Null Requirement	  */
	public String getChuBoe_UserElem2_NullReq();

    /** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";

	/** Set Project.
	  * Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID);

	/** Get Project.
	  * Financial Project
	  */
	public int getC_Project_ID();

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name PostingType */
    public static final String COLUMNNAME_PostingType = "PostingType";

	/** Set PostingType.
	  * The type of posted amount for the transaction
	  */
	public void setPostingType (String PostingType);

	/** Get PostingType.
	  * The type of posted amount for the transaction
	  */
	public String getPostingType();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name User1_ID */
    public static final String COLUMNNAME_User1_ID = "User1_ID";

	/** Set User Element List 1.
	  * User defined list element #1
	  */
	public void setUser1_ID (int User1_ID);

	/** Get User Element List 1.
	  * User defined list element #1
	  */
	public int getUser1_ID();

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException;

    /** Column name User2_ID */
    public static final String COLUMNNAME_User2_ID = "User2_ID";

	/** Set User Element List 2.
	  * User defined list element #2
	  */
	public void setUser2_ID (int User2_ID);

	/** Get User Element List 2.
	  * User defined list element #2
	  */
	public int getUser2_ID();

	public org.compiere.model.I_C_ElementValue getUser2() throws RuntimeException;

    /** Column name UserElement1_ID */
    public static final String COLUMNNAME_UserElement1_ID = "UserElement1_ID";

	/** Set User Column 1.
	  * User defined accounting Element
	  */
	public void setUserElement1_ID (int UserElement1_ID);

	/** Get User Column 1.
	  * User defined accounting Element
	  */
	public int getUserElement1_ID();

	public org.compiere.model.I_M_Shipper getUserElement1() throws RuntimeException;

    /** Column name UserElement2_ID */
    public static final String COLUMNNAME_UserElement2_ID = "UserElement2_ID";

	/** Set User Column 2.
	  * User defined accounting Element
	  */
	public void setUserElement2_ID (int UserElement2_ID);

	/** Get User Column 2.
	  * User defined accounting Element
	  */
	public int getUserElement2_ID();

	public org.compiere.model.I_M_Shipper getUserElement2() throws RuntimeException;
}
