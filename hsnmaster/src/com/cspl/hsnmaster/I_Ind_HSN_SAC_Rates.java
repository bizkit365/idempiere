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
package com.cspl.hsnmaster;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for Ind_HSN_SAC_Rates
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_Ind_HSN_SAC_Rates 
{

    /** TableName=Ind_HSN_SAC_Rates */
    public static final String Table_Name = "Ind_HSN_SAC_Rates";

    /** AD_Table_ID=1000004 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

    /** Load Meta Data */

    /** Column name activefrom */
    public static final String COLUMNNAME_activefrom = "activefrom";

	/** Set activefrom	  */
	public void setactivefrom (Timestamp activefrom);

	/** Get activefrom	  */
	public Timestamp getactivefrom();

    /** Column name activeto */
    public static final String COLUMNNAME_activeto = "activeto";

	/** Set activeto	  */
	public void setactiveto (Timestamp activeto);

	/** Get activeto	  */
	public Timestamp getactiveto();

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

    /** Column name ind_cessrate */
    public static final String COLUMNNAME_ind_cessrate = "ind_cessrate";

	/** Set ind_cessrate	  */
	public void setind_cessrate (BigDecimal ind_cessrate);

	/** Get ind_cessrate	  */
	public BigDecimal getind_cessrate();

    /** Column name ind_cgstrate */
    public static final String COLUMNNAME_ind_cgstrate = "ind_cgstrate";

	/** Set ind_cgstrate	  */
	public void setind_cgstrate (BigDecimal ind_cgstrate);

	/** Get ind_cgstrate	  */
	public BigDecimal getind_cgstrate();

    /** Column name ind_gstrate */
    public static final String COLUMNNAME_ind_gstrate = "ind_gstrate";

	/** Set ind_gstrate	  */
	public void setind_gstrate (BigDecimal ind_gstrate);

	/** Get ind_gstrate	  */
	public BigDecimal getind_gstrate();

    /** Column name IND_HSN_SAC_CODES_ID */
    public static final String COLUMNNAME_IND_HSN_SAC_CODES_ID = "IND_HSN_SAC_CODES_ID";

	/** Set HSN / SAC CODE	  */
	public void setIND_HSN_SAC_CODES_ID (int IND_HSN_SAC_CODES_ID);

	/** Get HSN / SAC CODE	  */
	public int getIND_HSN_SAC_CODES_ID();

	public I_Ind_HSN_SAC_Codes getIND_HSN_SAC_CODES() throws RuntimeException;

    /** Column name IND_HSN_SAC_RATES_ID */
    public static final String COLUMNNAME_IND_HSN_SAC_RATES_ID = "IND_HSN_SAC_RATES_ID";

	/** Set HSN / SAC Rates	  */
	public void setIND_HSN_SAC_RATES_ID (int IND_HSN_SAC_RATES_ID);

	/** Get HSN / SAC Rates	  */
	public int getIND_HSN_SAC_RATES_ID();

    /** Column name IND_HSN_SAC_RATES_UU */
    public static final String COLUMNNAME_IND_HSN_SAC_RATES_UU = "IND_HSN_SAC_RATES_UU";

	/** Set IND_HSN_SAC_RATES_UU	  */
	public void setIND_HSN_SAC_RATES_UU (String IND_HSN_SAC_RATES_UU);

	/** Get IND_HSN_SAC_RATES_UU	  */
	public String getIND_HSN_SAC_RATES_UU();

    /** Column name ind_igstrate */
    public static final String COLUMNNAME_ind_igstrate = "ind_igstrate";

	/** Set ind_igstrate	  */
	public void setind_igstrate (BigDecimal ind_igstrate);

	/** Get ind_igstrate	  */
	public BigDecimal getind_igstrate();

    /** Column name ind_sgstrate */
    public static final String COLUMNNAME_ind_sgstrate = "ind_sgstrate";

	/** Set ind_sgstrate	  */
	public void setind_sgstrate (BigDecimal ind_sgstrate);

	/** Get ind_sgstrate	  */
	public BigDecimal getind_sgstrate();

    /** Column name ind_utgstrate */
    public static final String COLUMNNAME_ind_utgstrate = "ind_utgstrate";

	/** Set ind_utgstrate	  */
	public void setind_utgstrate (BigDecimal ind_utgstrate);

	/** Get ind_utgstrate	  */
	public BigDecimal getind_utgstrate();

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

    /** Column name isitc */
    public static final String COLUMNNAME_isitc = "isitc";

	/** Set isitc	  */
	public void setisitc (boolean isitc);

	/** Get isitc	  */
	public boolean isitc();

    /** Column name isservice */
    public static final String COLUMNNAME_isservice = "isservice";

	/** Set isservice	  */
	public void setisservice (boolean isservice);

	/** Get isservice	  */
	public boolean isservice();

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
