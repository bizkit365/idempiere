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

/** Generated Model for Ind_HSN_SAC_Rates
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_Ind_HSN_SAC_Rates extends PO implements I_Ind_HSN_SAC_Rates, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180924L;

    /** Standard Constructor */
    public X_Ind_HSN_SAC_Rates (Properties ctx, int Ind_HSN_SAC_Rates_ID, String trxName)
    {
      super (ctx, Ind_HSN_SAC_Rates_ID, trxName);
      /** if (Ind_HSN_SAC_Rates_ID == 0)
        {
			setIND_HSN_SAC_RATES_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Ind_HSN_SAC_Rates (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Ind_HSN_SAC_Rates[")
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

	/** Set ind_cessrate.
		@param ind_cessrate ind_cessrate	  */
	public void setind_cessrate (BigDecimal ind_cessrate)
	{
		set_Value (COLUMNNAME_ind_cessrate, ind_cessrate);
	}

	/** Get ind_cessrate.
		@return ind_cessrate	  */
	public BigDecimal getind_cessrate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ind_cessrate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set ind_cgstrate.
		@param ind_cgstrate ind_cgstrate	  */
	public void setind_cgstrate (BigDecimal ind_cgstrate)
	{
		set_Value (COLUMNNAME_ind_cgstrate, ind_cgstrate);
	}

	/** Get ind_cgstrate.
		@return ind_cgstrate	  */
	public BigDecimal getind_cgstrate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ind_cgstrate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set ind_gstrate.
		@param ind_gstrate ind_gstrate	  */
	public void setind_gstrate (BigDecimal ind_gstrate)
	{
		set_Value (COLUMNNAME_ind_gstrate, ind_gstrate);
	}

	/** Get ind_gstrate.
		@return ind_gstrate	  */
	public BigDecimal getind_gstrate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ind_gstrate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_Ind_HSN_SAC_Codes getIND_HSN_SAC_CODES() throws RuntimeException
    {
		return (I_Ind_HSN_SAC_Codes)MTable.get(getCtx(), I_Ind_HSN_SAC_Codes.Table_Name)
			.getPO(getIND_HSN_SAC_CODES_ID(), get_TrxName());	}

	/** Set HSN / SAC CODE.
		@param IND_HSN_SAC_CODES_ID HSN / SAC CODE	  */
	public void setIND_HSN_SAC_CODES_ID (int IND_HSN_SAC_CODES_ID)
	{
		if (IND_HSN_SAC_CODES_ID < 1) 
			set_Value (COLUMNNAME_IND_HSN_SAC_CODES_ID, null);
		else 
			set_Value (COLUMNNAME_IND_HSN_SAC_CODES_ID, Integer.valueOf(IND_HSN_SAC_CODES_ID));
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

	/** Set HSN / SAC Rates.
		@param IND_HSN_SAC_RATES_ID HSN / SAC Rates	  */
	public void setIND_HSN_SAC_RATES_ID (int IND_HSN_SAC_RATES_ID)
	{
		if (IND_HSN_SAC_RATES_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_IND_HSN_SAC_RATES_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_IND_HSN_SAC_RATES_ID, Integer.valueOf(IND_HSN_SAC_RATES_ID));
	}

	/** Get HSN / SAC Rates.
		@return HSN / SAC Rates	  */
	public int getIND_HSN_SAC_RATES_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IND_HSN_SAC_RATES_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IND_HSN_SAC_RATES_UU.
		@param IND_HSN_SAC_RATES_UU IND_HSN_SAC_RATES_UU	  */
	public void setIND_HSN_SAC_RATES_UU (String IND_HSN_SAC_RATES_UU)
	{
		set_ValueNoCheck (COLUMNNAME_IND_HSN_SAC_RATES_UU, IND_HSN_SAC_RATES_UU);
	}

	/** Get IND_HSN_SAC_RATES_UU.
		@return IND_HSN_SAC_RATES_UU	  */
	public String getIND_HSN_SAC_RATES_UU () 
	{
		return (String)get_Value(COLUMNNAME_IND_HSN_SAC_RATES_UU);
	}

	/** Set ind_igstrate.
		@param ind_igstrate ind_igstrate	  */
	public void setind_igstrate (BigDecimal ind_igstrate)
	{
		set_Value (COLUMNNAME_ind_igstrate, ind_igstrate);
	}

	/** Get ind_igstrate.
		@return ind_igstrate	  */
	public BigDecimal getind_igstrate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ind_igstrate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set ind_sgstrate.
		@param ind_sgstrate ind_sgstrate	  */
	public void setind_sgstrate (BigDecimal ind_sgstrate)
	{
		set_Value (COLUMNNAME_ind_sgstrate, ind_sgstrate);
	}

	/** Get ind_sgstrate.
		@return ind_sgstrate	  */
	public BigDecimal getind_sgstrate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ind_sgstrate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set ind_utgstrate.
		@param ind_utgstrate ind_utgstrate	  */
	public void setind_utgstrate (BigDecimal ind_utgstrate)
	{
		set_Value (COLUMNNAME_ind_utgstrate, ind_utgstrate);
	}

	/** Get ind_utgstrate.
		@return ind_utgstrate	  */
	public BigDecimal getind_utgstrate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ind_utgstrate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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