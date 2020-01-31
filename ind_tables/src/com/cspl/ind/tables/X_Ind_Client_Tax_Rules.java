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
import org.compiere.util.KeyNamePair;

/** Generated Model for Ind_Client_Tax_Rules
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_Ind_Client_Tax_Rules extends PO implements I_Ind_Client_Tax_Rule, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180924L;

    /** Standard Constructor */
    public X_Ind_Client_Tax_Rules (Properties ctx, int Ind_Client_Tax_Rules_ID, String trxName)
    {
      super (ctx, Ind_Client_Tax_Rules_ID, trxName);
      /** if (Ind_Client_Tax_Rules_ID == 0)
        {
			setC_Tax_ID (0);
			setInd_Buyer_Tax_Entity_Type_ID (0);
			setInd_Client_Tax_Rules_ID (0);
			setInd_Seller_Tax_Entity_Type_ID (0);
			setInd_Tax_Category_ID (0);
			setInd_Tax_Rules_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_Ind_Client_Tax_Rules (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Ind_Client_Tax_Rules[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set activefrom.
		@param activefrom activefrom	  */
	public void setactivefrom (Timestamp activefrom)
	{
		set_Value (COLUMNNAME_activefrom, activefrom);
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
		set_Value (COLUMNNAME_activeto, activeto);
	}

	/** Get activeto.
		@return activeto	  */
	public Timestamp getactiveto () 
	{
		return (Timestamp)get_Value(COLUMNNAME_activeto);
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
		if (C_Tax_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Tax_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
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

	public I_Ind_Tax_Entity_Type getInd_Buyer_Tax_Entity_Type() throws RuntimeException
    {
		return (I_Ind_Tax_Entity_Type)MTable.get(getCtx(), I_Ind_Tax_Entity_Type.Table_Name)
			.getPO(getInd_Buyer_Tax_Entity_Type_ID(), get_TrxName());	}

	/** Set Buyer Tax Entity Type.
		@param Ind_Buyer_Tax_Entity_Type_ID Buyer Tax Entity Type	  */
	public void setInd_Buyer_Tax_Entity_Type_ID (int Ind_Buyer_Tax_Entity_Type_ID)
	{
		if (Ind_Buyer_Tax_Entity_Type_ID < 1) 
			set_Value (COLUMNNAME_Ind_Buyer_Tax_Entity_Type_ID, null);
		else 
			set_Value (COLUMNNAME_Ind_Buyer_Tax_Entity_Type_ID, Integer.valueOf(Ind_Buyer_Tax_Entity_Type_ID));
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

	/** Set Cess Rate.
		@param Ind_Cess_Rate Cess Rate	  */
	public void setInd_Cess_Rate (BigDecimal Ind_Cess_Rate)
	{
		set_Value (COLUMNNAME_Ind_Cess_Rate, Ind_Cess_Rate);
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

	/** Set Client Tax Rules.
		@param Ind_Client_Tax_Rules_ID Client Tax Rules	  */
	public void setInd_Client_Tax_Rules_ID (int Ind_Client_Tax_Rules_ID)
	{
		if (Ind_Client_Tax_Rules_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Ind_Client_Tax_Rules_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Ind_Client_Tax_Rules_ID, Integer.valueOf(Ind_Client_Tax_Rules_ID));
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

	/** Set Ind_Client_Tax_Rules_UU.
		@param Ind_Client_Tax_Rules_UU Ind_Client_Tax_Rules_UU	  */
	public void setInd_Client_Tax_Rules_UU (String Ind_Client_Tax_Rules_UU)
	{
		set_Value (COLUMNNAME_Ind_Client_Tax_Rules_UU, Ind_Client_Tax_Rules_UU);
	}

	/** Get Ind_Client_Tax_Rules_UU.
		@return Ind_Client_Tax_Rules_UU	  */
	public String getInd_Client_Tax_Rules_UU () 
	{
		return (String)get_Value(COLUMNNAME_Ind_Client_Tax_Rules_UU);
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
		if (Ind_Seller_Tax_Entity_Type_ID < 1) 
			set_Value (COLUMNNAME_Ind_Seller_Tax_Entity_Type_ID, null);
		else 
			set_Value (COLUMNNAME_Ind_Seller_Tax_Entity_Type_ID, Integer.valueOf(Ind_Seller_Tax_Entity_Type_ID));
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

	public I_Ind_Tax_Category getInd_Tax_Category() throws RuntimeException
    {
		return (I_Ind_Tax_Category)MTable.get(getCtx(), I_Ind_Tax_Category.Table_Name)
			.getPO(getInd_Tax_Category_ID(), get_TrxName());	}

	/** Set Ind_Tax_Category_ID.
		@param Ind_Tax_Category_ID Ind_Tax_Category_ID	  */
	public void setInd_Tax_Category_ID (int Ind_Tax_Category_ID)
	{
		if (Ind_Tax_Category_ID < 1) 
			set_Value (COLUMNNAME_Ind_Tax_Category_ID, null);
		else 
			set_Value (COLUMNNAME_Ind_Tax_Category_ID, Integer.valueOf(Ind_Tax_Category_ID));
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

	public I_Ind_Tax_Rule_Category getInd_Tax_Rules_Category() throws RuntimeException
    {
		return (I_Ind_Tax_Rule_Category)MTable.get(getCtx(), I_Ind_Tax_Rule_Category.Table_Name)
			.getPO(getInd_Tax_Rules_Category_ID(), get_TrxName());	}

	/** Set Ind_Tax_Rules_ID.
		@param Ind_Tax_Rules_ID 
		Tax Rules ID
	  */
	public void setInd_Tax_Rule_Category_ID (int Ind_Tax_Rules_ID)
	{
		if (Ind_Tax_Rules_ID < 1) 
			set_Value (COLUMNNAME_Ind_Tax_Rules_ID, null);
		else 
			set_Value (COLUMNNAME_Ind_Tax_Rules_ID, Integer.valueOf(Ind_Tax_Rules_ID));
	}

	/** Get Ind_Tax_Rules_ID.
		@return Tax Rules ID
	  */
	public int getInd_Tax_Rules_Category_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Tax_Rules_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set isgst.
		@param isgst isgst	  */
	public void setisgst (boolean isgst)
	{
		set_Value (COLUMNNAME_isgst, Boolean.valueOf(isgst));
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
		set_Value (COLUMNNAME_isitc, Boolean.valueOf(isitc));
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
		set_Value (COLUMNNAME_islocal, Boolean.valueOf(islocal));
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
		set_Value (COLUMNNAME_isservice, Boolean.valueOf(isservice));
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

	/** Set tax_levied_on_item.
		@param tax_levied_on_item tax_levied_on_item	  */
	public void settax_levied_on_item (boolean tax_levied_on_item)
	{
		set_Value (COLUMNNAME_tax_levied_on_item, Boolean.valueOf(tax_levied_on_item));
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
	public void settax_rate (BigDecimal tax_rate)
	{
		set_Value (COLUMNNAME_tax_rate, tax_rate);
	}

	/** Get Tax_Rate.
		@return Tax_Rate	  */
	public BigDecimal gettax_rate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_tax_rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	@Override
	public void setInd_Tax_Rules_ID(int Ind_Tax_Rules_ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInd_Tax_Rules_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public I_Ind_Tax_Rule_Category getInd_Tax_Rules() throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
}