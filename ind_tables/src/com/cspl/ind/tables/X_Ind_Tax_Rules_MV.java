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
package com.cspl.ind.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for Ind_Tax_Rules_MV
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_Ind_Tax_Rules_MV extends PO implements I_Ind_Tax_Rules_MV, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180925L;

    /** Standard Constructor */
    public X_Ind_Tax_Rules_MV (Properties ctx, int Ind_Tax_Rules_MV_ID, String trxName)
    {
      super (ctx, Ind_Tax_Rules_MV_ID, trxName);
      /** if (Ind_Tax_Rules_MV_ID == 0)
        {
        } */
    }

    /** Load Constructor */
    public X_Ind_Tax_Rules_MV (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System 
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
      StringBuffer sb = new StringBuffer ("X_Ind_Tax_Rules_MV[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set activefrom.
		@param activefrom activefrom	  */
	public void setactivefrom (Timestamp activefrom)
	{
		//set_Value (COLUMNNAME_activefrom, activefrom);
	}

	/** Get activefrom.
		@return activefrom	  */
	public Timestamp getactivefrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_activefrom);
	}

	/** Set activeto.
		@param activeto activeto	  */
	public void setactiveto (Timestamp activeto)
	{
		//set_Value (COLUMNNAME_activeto, activeto);
	}

	/** Get activeto.
		@return activeto	  */
	public Timestamp getactiveto () 
	{
		return (Timestamp)get_Value(COLUMNNAME_activeto);
	}

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
//		if (C_Tax_ID < 1) 
//			set_ValueNoCheck (COLUMNNAME_C_Tax_ID, null);
//		else 
//			set_ValueNoCheck (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set c_tax_name.
		@param c_tax_name c_tax_name	  */
	public void setc_tax_name (String c_tax_name)
	{
		//set_ValueNoCheck (COLUMNNAME_c_tax_name, c_tax_name);
	}

	/** Get c_tax_name.
		@return c_tax_name	  */
	public String getc_tax_name () 
	{
		return (String)get_Value(COLUMNNAME_c_tax_name);
	}

	public I_Ind_Tax_Entity_Type getInd_Buyer_Tax_Entity_Type() throws RuntimeException
    {
		return (I_Ind_Tax_Entity_Type)MTable.get(getCtx(), I_Ind_Tax_Entity_Type.Table_Name)
			.getPO(getInd_Buyer_Tax_Entity_Type_ID(), get_TrxName());	}

	/** Set Buyer Tax Entity Type.
		@param Ind_Buyer_Tax_Entity_Type_ID Buyer Tax Entity Type	  */
	public void setInd_Buyer_Tax_Entity_Type_ID (int Ind_Buyer_Tax_Entity_Type_ID)
	{
//		if (Ind_Buyer_Tax_Entity_Type_ID < 1) 
//			set_Value (COLUMNNAME_Ind_Buyer_Tax_Entity_Type_ID, null);
//		else 
//			set_Value (COLUMNNAME_Ind_Buyer_Tax_Entity_Type_ID, Integer.valueOf(Ind_Buyer_Tax_Entity_Type_ID));
	}

	/** Get Buyer Tax Entity Type.
		@return Buyer Tax Entity Type	  */
	public int getInd_Buyer_Tax_Entity_Type_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Buyer_Tax_Entity_Type_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ind_buyer_tax_entity_type_value.
		@param ind_buyer_tax_entity_type_value ind_buyer_tax_entity_type_value	  */
	public void setind_buyer_tax_entity_type_value (String ind_buyer_tax_entity_type_value)
	{
		//set_Value (COLUMNNAME_ind_buyer_tax_entity_type_value, ind_buyer_tax_entity_type_value);
	}

	/** Get ind_buyer_tax_entity_type_value.
		@return ind_buyer_tax_entity_type_value	  */
	public String getind_buyer_tax_entity_type_value () 
	{
		return (String)get_Value(COLUMNNAME_ind_buyer_tax_entity_type_value);
	}

	/** Set Cess Rate.
		@param Ind_Cess_Rate Cess Rate	  */
	public void setInd_Cess_Rate (BigDecimal Ind_Cess_Rate)
	{
		//set_Value (COLUMNNAME_Ind_Cess_Rate, Ind_Cess_Rate);
	}

	/** Get Cess Rate.
		@return Cess Rate	  */
	public BigDecimal getInd_Cess_Rate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Ind_Cess_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_Ind_Tax_Rule_Category getInd_Client_Tax_Rules() throws RuntimeException
    {
		return (I_Ind_Tax_Rule_Category)MTable.get(getCtx(), I_Ind_Tax_Rule_Category.Table_Name)
			.getPO(getInd_Client_Tax_Rules_ID(), get_TrxName());	}

	/** Set Client Tax Rules.
		@param Ind_Client_Tax_Rules_ID Client Tax Rules	  */
	public void setInd_Client_Tax_Rules_ID (int Ind_Client_Tax_Rules_ID)
	{
//		if (Ind_Client_Tax_Rules_ID < 1) 
//			set_ValueNoCheck (COLUMNNAME_Ind_Client_Tax_Rules_ID, null);
//		else 
//			set_ValueNoCheck (COLUMNNAME_Ind_Client_Tax_Rules_ID, Integer.valueOf(Ind_Client_Tax_Rules_ID));
	}

	/** Get Client Tax Rules.
		@return Client Tax Rules	  */
	public int getInd_Client_Tax_Rules_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Client_Tax_Rules_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_Ind_Tax_Entity_Type getInd_Seller_Tax_Entity_Type() throws RuntimeException
    {
		return (I_Ind_Tax_Entity_Type)MTable.get(getCtx(), I_Ind_Tax_Entity_Type.Table_Name)
			.getPO(getInd_Seller_Tax_Entity_Type_ID(), get_TrxName());	}

	/** Set Seller Tax Entity Type.
		@param Ind_Seller_Tax_Entity_Type_ID 
		Seller Tax Entity Type
	  */
	public void setInd_Seller_Tax_Entity_Type_ID (int Ind_Seller_Tax_Entity_Type_ID)
	{
//		if (Ind_Seller_Tax_Entity_Type_ID < 1) 
//			set_Value (COLUMNNAME_Ind_Seller_Tax_Entity_Type_ID, null);
//		else 
//			set_Value (COLUMNNAME_Ind_Seller_Tax_Entity_Type_ID, Integer.valueOf(Ind_Seller_Tax_Entity_Type_ID));
	}

	/** Get Seller Tax Entity Type.
		@return Seller Tax Entity Type
	  */
	public int getInd_Seller_Tax_Entity_Type_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Seller_Tax_Entity_Type_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ind_seller_tax_entity_type_value.
		@param ind_seller_tax_entity_type_value ind_seller_tax_entity_type_value	  */
	public void setind_seller_tax_entity_type_value (String ind_seller_tax_entity_type_value)
	{
		//set_Value (COLUMNNAME_ind_seller_tax_entity_type_value, ind_seller_tax_entity_type_value);
	}

	/** Get ind_seller_tax_entity_type_value.
		@return ind_seller_tax_entity_type_value	  */
	public String getind_seller_tax_entity_type_value () 
	{
		return (String)get_Value(COLUMNNAME_ind_seller_tax_entity_type_value);
	}

	public I_Ind_Tax_Category getInd_Tax_Category() throws RuntimeException
    {
		return (I_Ind_Tax_Category)MTable.get(getCtx(), I_Ind_Tax_Category.Table_Name)
			.getPO(getInd_Tax_Category_ID(), get_TrxName());	}

	/** Set Ind_Tax_Category_ID.
		@param Ind_Tax_Category_ID Ind_Tax_Category_ID	  */
	public void setInd_Tax_Category_ID (int Ind_Tax_Category_ID)
	{
//		if (Ind_Tax_Category_ID < 1) 
//			set_Value (COLUMNNAME_Ind_Tax_Category_ID, null);
//		else 
//			set_Value (COLUMNNAME_Ind_Tax_Category_ID, Integer.valueOf(Ind_Tax_Category_ID));
	}

	/** Get Ind_Tax_Category_ID.
		@return Ind_Tax_Category_ID	  */
	public int getInd_Tax_Category_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Tax_Category_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ind_taxcategory_name.
		@param ind_taxcategory_name ind_taxcategory_name	  */
	public void setind_taxcategory_name (String ind_taxcategory_name)
	{
		//set_Value (COLUMNNAME_ind_taxcategory_name, ind_taxcategory_name);
	}

	/** Get ind_taxcategory_name.
		@return ind_taxcategory_name	  */
	public String getind_taxcategory_name () 
	{
		return (String)get_Value(COLUMNNAME_ind_taxcategory_name);
	}

	/** Set isgst.
		@param isgst isgst	  */
	public void setisgst (boolean isgst)
	{
		//set_Value (COLUMNNAME_isgst, Boolean.valueOf(isgst));
	}

	/** Get isgst.
		@return isgst	  */
	public boolean isgst () 
	{
		Object oo = get_Value(COLUMNNAME_isgst);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set isitc.
		@param isitc isitc	  */
	public void setisitc (boolean isitc)
	{
		//set_Value (COLUMNNAME_isitc, Boolean.valueOf(isitc));
	}

	/** Get isitc.
		@return isitc	  */
	public boolean isitc () 
	{
		Object oo = get_Value(COLUMNNAME_isitc);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set islocal.
		@param islocal islocal	  */
	public void setislocal (boolean islocal)
	{
		//set_Value (COLUMNNAME_islocal, Boolean.valueOf(islocal));
	}

	/** Get islocal.
		@return islocal	  */
	public boolean islocal () 
	{
		Object oo = get_Value(COLUMNNAME_islocal);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set isservice.
		@param isservice isservice	  */
	public void setisservice (boolean isservice)
	{
		//set_Value (COLUMNNAME_isservice, Boolean.valueOf(isservice));
	}

	/** Get isservice.
		@return isservice	  */
	public boolean isservice () 
	{
		Object oo = get_Value(COLUMNNAME_isservice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set tax_levied_on_item.
		@param tax_levied_on_item tax_levied_on_item	  */
	public void settax_levied_on_item (boolean tax_levied_on_item)
	{
		//set_Value (COLUMNNAME_tax_levied_on_item, Boolean.valueOf(tax_levied_on_item));
	}

	/** Get tax_levied_on_item.
		@return tax_levied_on_item	  */
	public boolean istax_levied_on_item () 
	{
		Object oo = get_Value(COLUMNNAME_tax_levied_on_item);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Tax_Rate.
		@param tax_rate Tax_Rate	  */
	public void settax_rate (int tax_rate)
	{
		//set_Value (COLUMNNAME_tax_rate, Integer.valueOf(tax_rate));
	}

	/** Get Tax_Rate.
		@return Tax_Rate	  */
	public int gettax_rate () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_tax_rate);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		//set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	@Override
	public void setInd_Tax_Item_Type_ID(int Ind_Tax_Item_Type_ID) 
	{
		// view do nothing;
	}

	@Override
	public int getInd_Tax_Item_Type_ID() {
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Tax_Item_Type_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public I_Ind_Tax_Item_Type getInd_Item_Tax_Type(String ind_Tax_Item_type_value) throws RuntimeException {
		// TODO Auto-generated method stub
		return (I_Ind_Tax_Item_Type)MTable.get(getCtx(), I_Ind_Tax_Item_Type.Table_Name)
				.getPO(getInd_Tax_Item_Type_ID(), get_TrxName());	
		
	}
	
}