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

/** Generated Interface for Ind_Tax_Rules_MV
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_Ind_Tax_Rules_MV 
{

    /** TableName=Ind_Tax_Rules_MV */
    public static final String Table_Name = "Ind_Tax_Rules_MV";

    /** AD_Table_ID=1000018 */
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

    /** Column name C_Tax_ID */
    public static final String COLUMNNAME_C_Tax_ID = "C_Tax_ID";

	/** Set Tax.
	  * Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID);

	/** Get Tax.
	  * Tax identifier
	  */
	public int getC_Tax_ID();

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException;

    /** Column name c_tax_name */
    public static final String COLUMNNAME_c_tax_name = "c_tax_name";

	/** Set c_tax_name	  */
	public void setc_tax_name (String c_tax_name);

	/** Get c_tax_name	  */
	public String getc_tax_name();

    /** Column name Ind_Buyer_Tax_Entity_Type_ID */
    public static final String COLUMNNAME_Ind_Buyer_Tax_Entity_Type_ID = "Ind_Buyer_Tax_Entity_Type_ID";

	/** Set Buyer Tax Entity Type	  */
	public void setInd_Buyer_Tax_Entity_Type_ID (int Ind_Buyer_Tax_Entity_Type_ID);

	/** Get Buyer Tax Entity Type	  */
	public int getInd_Buyer_Tax_Entity_Type_ID();

	public I_Ind_Tax_Entity_Type getInd_Buyer_Tax_Entity_Type() throws RuntimeException;

    /** Column name ind_buyer_tax_entity_type_value */
    public static final String COLUMNNAME_ind_buyer_tax_entity_type_value = "ind_buyer_tax_entity_type_value";

	/** Set ind_buyer_tax_entity_type_value	  */
	public void setind_buyer_tax_entity_type_value (String ind_buyer_tax_entity_type_value);

	/** Get ind_buyer_tax_entity_type_value	  */
	public String getind_buyer_tax_entity_type_value();
	
	//--------------------------------------------- 
	 /** Column name Ind_Tax_Item_Type_ID */
    public static final String COLUMNNAME_Ind_Tax_Item_Type_ID = "Ind_Tax_Item_Type_ID";

	/** Set ind_buyer_tax_entity_type_value	  */
	public void setInd_Tax_Item_Type_ID (int Ind_Tax_Item_Type_ID);

	/** Get ind_buyer_tax_entity_type_value	  */
	public int getInd_Tax_Item_Type_ID();
	
	public I_Ind_Tax_Item_Type getInd_Item_Tax_Type(String ind_Tax_Item_type_value) throws RuntimeException;;
	//--------------------------------------------
	/** Column name Ind_Cess_Rate */
    public static final String COLUMNNAME_Ind_Cess_Rate = "Ind_Cess_Rate";

	/** Set Cess Rate	  */
	public void setInd_Cess_Rate (BigDecimal Ind_Cess_Rate);

	/** Get Cess Rate	  */
	public BigDecimal getInd_Cess_Rate();

    /** Column name Ind_Client_Tax_Rules_ID */
    public static final String COLUMNNAME_Ind_Client_Tax_Rules_ID = "Ind_Client_Tax_Rules_ID";

	/** Set Client Tax Rules	  */
	public void setInd_Client_Tax_Rules_ID (int Ind_Client_Tax_Rules_ID);

	/** Get Client Tax Rules	  */
	public int getInd_Client_Tax_Rules_ID();

	public I_Ind_Tax_Rule_Category getInd_Client_Tax_Rules() throws RuntimeException;

    /** Column name Ind_Seller_Tax_Entity_Type_ID */
    public static final String COLUMNNAME_Ind_Seller_Tax_Entity_Type_ID = "Ind_Seller_Tax_Entity_Type_ID";

	/** Set Seller Tax Entity Type.
	  * Seller Tax Entity Type
	  */
	public void setInd_Seller_Tax_Entity_Type_ID (int Ind_Seller_Tax_Entity_Type_ID);

	/** Get Seller Tax Entity Type.
	  * Seller Tax Entity Type
	  */
	public int getInd_Seller_Tax_Entity_Type_ID();

	public I_Ind_Tax_Entity_Type getInd_Seller_Tax_Entity_Type() throws RuntimeException;

    /** Column name ind_seller_tax_entity_type_value */
    public static final String COLUMNNAME_ind_seller_tax_entity_type_value = "ind_seller_tax_entity_type_value";

	/** Set ind_seller_tax_entity_type_value	  */
	public void setind_seller_tax_entity_type_value (String ind_seller_tax_entity_type_value);

	/** Get ind_seller_tax_entity_type_value	  */
	public String getind_seller_tax_entity_type_value();

    /** Column name Ind_Tax_Category_ID */
    public static final String COLUMNNAME_Ind_Tax_Category_ID = "Ind_Tax_Category_ID";

	/** Set Ind_Tax_Category_ID	  */
	public void setInd_Tax_Category_ID (int Ind_Tax_Category_ID);

	/** Get Ind_Tax_Category_ID	  */
	public int getInd_Tax_Category_ID();

	public I_Ind_Tax_Category getInd_Tax_Category() throws RuntimeException;

    /** Column name ind_taxcategory_name */
    public static final String COLUMNNAME_ind_taxcategory_name = "ind_taxcategory_name";

	/** Set ind_taxcategory_name	  */
	public void setind_taxcategory_name (String ind_taxcategory_name);

	/** Get ind_taxcategory_name	  */
	public String getind_taxcategory_name();

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

    /** Column name isgst */
    public static final String COLUMNNAME_isgst = "isgst";

	/** Set isgst	  */
	public void setisgst (boolean isgst);

	/** Get isgst	  */
	public boolean isgst();

    /** Column name isitc */
    public static final String COLUMNNAME_isitc = "isitc";

	/** Set isitc	  */
	public void setisitc (boolean isitc);

	/** Get isitc	  */
	public boolean isitc();

    /** Column name islocal */
    public static final String COLUMNNAME_islocal = "islocal";

	/** Set islocal	  */
	public void setislocal (boolean islocal);

	/** Get islocal	  */
	public boolean islocal();

    /** Column name isservice */
    public static final String COLUMNNAME_isservice = "isservice";

	/** Set isservice	  */
	public void setisservice (boolean isservice);

	/** Get isservice	  */
	public boolean isservice();

    /** Column name tax_levied_on_item */
    public static final String COLUMNNAME_tax_levied_on_item = "tax_levied_on_item";

	/** Set tax_levied_on_item	  */
	public void settax_levied_on_item (boolean tax_levied_on_item);

	/** Get tax_levied_on_item	  */
	public boolean istax_levied_on_item();

    /** Column name tax_rate */
    public static final String COLUMNNAME_tax_rate = "tax_rate";

	/** Set Tax_Rate	  */
	public void settax_rate (int tax_rate);

	/** Get Tax_Rate	  */
	public int gettax_rate();

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
