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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for Ind_HSN_SAC_Codes
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_Ind_HSN_SAC_Codes extends PO implements I_Ind_HSN_SAC_Codes, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180924L;

    /** Standard Constructor */
    public X_Ind_HSN_SAC_Codes (Properties ctx, int Ind_HSN_SAC_Codes_ID, String trxName)
    {
      super (ctx, Ind_HSN_SAC_Codes_ID, trxName);
      /** if (Ind_HSN_SAC_Codes_ID == 0)
        {
			setIND_HSN_SAC_CODES_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Ind_HSN_SAC_Codes (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Ind_HSN_SAC_Codes[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set HSN / SAC CODE.
		@param IND_HSN_SAC_CODES_ID HSN / SAC CODE	  */
	public void setIND_HSN_SAC_CODES_ID (int IND_HSN_SAC_CODES_ID)
	{
		if (IND_HSN_SAC_CODES_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_IND_HSN_SAC_CODES_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_IND_HSN_SAC_CODES_ID, Integer.valueOf(IND_HSN_SAC_CODES_ID));
	}

	/** Get HSN / SAC CODE.
		@return HSN / SAC CODE	  */
	public int getIND_HSN_SAC_CODES_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IND_HSN_SAC_CODES_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IND_HSN_SAC_CODES_UU.
		@param IND_HSN_SAC_CODES_UU IND_HSN_SAC_CODES_UU	  */
	public void setIND_HSN_SAC_CODES_UU (String IND_HSN_SAC_CODES_UU)
	{
		set_Value (COLUMNNAME_IND_HSN_SAC_CODES_UU, IND_HSN_SAC_CODES_UU);
	}

	/** Get IND_HSN_SAC_CODES_UU.
		@return IND_HSN_SAC_CODES_UU	  */
	public String getIND_HSN_SAC_CODES_UU () 
	{
		return (String)get_Value(COLUMNNAME_IND_HSN_SAC_CODES_UU);
	}

	/** Set Long Description.
		@param ind_long_description 
		This is a long description of the product
	  */
	public void setind_long_description (String ind_long_description)
	{
		set_Value (COLUMNNAME_ind_long_description, ind_long_description);
	}

	/** Get Long Description.
		@return This is a long description of the product
	  */
	public String getind_long_description () 
	{
		return (String)get_Value(COLUMNNAME_ind_long_description);
	}

	/** Set Default.
		@param IsDefault 
		Default value
	  */
	public void setIsDefault (boolean IsDefault)
	{
		set_Value (COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
	}

	/** Get Default.
		@return Default value
	  */
	public boolean isDefault () 
	{
		Object oo = get_Value(COLUMNNAME_IsDefault);
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

	/** Set Parent link column.
		@param IsParent 
		This column is a link to the parent table (e.g. header from lines) - incl. Association key columns
	  */
	public void setIsParent (boolean IsParent)
	{
		set_Value (COLUMNNAME_IsParent, Boolean.valueOf(IsParent));
	}

	/** Get Parent link column.
		@return This column is a link to the parent table (e.g. header from lines) - incl. Association key columns
	  */
	public boolean isParent () 
	{
		Object oo = get_Value(COLUMNNAME_IsParent);
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
}