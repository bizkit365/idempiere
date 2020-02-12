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

/** Generated Model for Ind_Tax_Category
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_Ind_Tax_Category extends PO implements I_Ind_Tax_Category, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180924L;

    /** Standard Constructor */
    public X_Ind_Tax_Category (Properties ctx, int Ind_Tax_Category_ID, String trxName)
    {
      super (ctx, Ind_Tax_Category_ID, trxName);
      /** if (Ind_Tax_Category_ID == 0)
        {
			setInd_Tax_Category_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_Ind_Tax_Category (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Ind_Tax_Category[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Ind_Tax_Category_ID.
		@param Ind_Tax_Category_ID Ind_Tax_Category_ID	  */
	public void setInd_Tax_Category_ID (int Ind_Tax_Category_ID)
	{
		if (Ind_Tax_Category_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Ind_Tax_Category_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Ind_Tax_Category_ID, Integer.valueOf(Ind_Tax_Category_ID));
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

	/** Set Ind_Tax_Category_UU.
		@param Ind_Tax_Category_UU Ind_Tax_Category_UU	  */
	public void setInd_Tax_Category_UU (String Ind_Tax_Category_UU)
	{
		set_ValueNoCheck (COLUMNNAME_Ind_Tax_Category_UU, Ind_Tax_Category_UU);
	}

	/** Get Ind_Tax_Category_UU.
		@return Ind_Tax_Category_UU	  */
	public String getInd_Tax_Category_UU () 
	{
		return (String)get_Value(COLUMNNAME_Ind_Tax_Category_UU);
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