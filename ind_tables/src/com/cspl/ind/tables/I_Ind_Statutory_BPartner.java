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
package com.cspl.ind.tables;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for Ind_Statutory_BPartner
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_Ind_Statutory_BPartner 
{

    /** TableName=Ind_Statutory_BPartner */
    public static final String Table_Name = "Ind_Statutory_BPartner";

    /** AD_Table_ID=1000006 */
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

    /** Column name C_Location_ID */
    public static final String COLUMNNAME_C_Location_ID = "C_Location_ID";

	/** Set Address.
	  * Location or Address
	  */
	public void setC_Location_ID (int C_Location_ID);

	/** Get Address.
	  * Location or Address
	  */
	public int getC_Location_ID();

	public I_C_Location getC_Location() throws RuntimeException;

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

    /** Column name gstin_code */
    public static final String COLUMNNAME_gstin_code = "gstin_code";

	/** Set GSTIN	  */
	public void setgstin_code (String gstin_code);

	/** Get GSTIN	  */
	public String getgstin_code();

    /** Column name IND_Statutory_BPartner_ID */
    public static final String COLUMNNAME_IND_Statutory_BPartner_ID = "IND_Statutory_BPartner_ID";

	/** Set Indian Statutory Details.
	  * Indian statutory details that are required from business partners
	  */
	public void setIND_Statutory_BPartner_ID (int IND_Statutory_BPartner_ID);

	/** Get Indian Statutory Details.
	  * Indian statutory details that are required from business partners
	  */
	public int getIND_Statutory_BPartner_ID();

    /** Column name Ind_Statutory_BPartner_UU */
    public static final String COLUMNNAME_Ind_Statutory_BPartner_UU = "Ind_Statutory_BPartner_UU";

	/** Set Ind_Statutory_BPartner_UU	  */
	public void setInd_Statutory_BPartner_UU (String Ind_Statutory_BPartner_UU);

	/** Get Ind_Statutory_BPartner_UU	  */
	public String getInd_Statutory_BPartner_UU();

    /** Column name Ind_Tax_Category_ID */
    public static final String COLUMNNAME_Ind_Tax_Category_ID = "Ind_Tax_Category_ID";

	/** Set Ind_Tax_Category_ID	  */
	public void setInd_Tax_Category_ID (int Ind_Tax_Category_ID);

	/** Get Ind_Tax_Category_ID	  */
	public int getInd_Tax_Category_ID();

	public I_Ind_Tax_Category getInd_Tax_Category() throws RuntimeException;

    /** Column name Ind_Tax_Entity_Type_ID */
    public static final String COLUMNNAME_Ind_Tax_Entity_Type_ID = "Ind_Tax_Entity_Type_ID";

	/** Set Tax Entity Types.
	  * Entity type as per tax law
	  */
	public void setInd_Tax_Entity_Type_ID (int Ind_Tax_Entity_Type_ID);

	/** Get Tax Entity Types.
	  * Entity type as per tax law
	  */
	public int getInd_Tax_Entity_Type_ID();

	public I_Ind_Tax_Entity_Type getInd_Tax_Entity_Type() throws RuntimeException;

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

    /** Column name pan_no */
    public static final String COLUMNNAME_pan_no = "pan_no";

	/** Set PAN.
	  * Indian PAN Number
	  */
	public void setpan_no (String pan_no);

	/** Get PAN.
	  * Indian PAN Number
	  */
	public String getpan_no();

    /** Column name tan_no */
    public static final String COLUMNNAME_tan_no = "tan_no";

	/** Set TAN	  */
	public void settan_no (String tan_no);

	/** Get TAN	  */
	public String gettan_no();

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

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
