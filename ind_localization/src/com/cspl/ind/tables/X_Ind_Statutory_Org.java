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

/** Generated Model for Ind_Statutory_Org
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_Ind_Statutory_Org extends PO implements I_Ind_Statutory_Org, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180924L;

    /** Standard Constructor */
    public X_Ind_Statutory_Org (Properties ctx, int Ind_Statutory_Org_ID, String trxName)
    {
      super (ctx, Ind_Statutory_Org_ID, trxName);
      /** if (Ind_Statutory_Org_ID == 0)
        {
			setIND_Statutory_Org_ID (0);
			setInd_Tax_Category_ID (0);
			setInd_Tax_Entity_Type_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Ind_Statutory_Org (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuffer sb = new StringBuffer ("X_Ind_Statutory_Org[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_C_Location getC_Location() throws RuntimeException
    {
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_Name)
			.getPO(getC_Location_ID(), get_TrxName());	}

	/** Set Address.
		@param C_Location_ID 
		Location or Address
	  */
	public void setC_Location_ID (int C_Location_ID)
	{
		if (C_Location_ID < 1) 
			set_Value (COLUMNNAME_C_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
	}

	/** Get Address.
		@return Location or Address
	  */
	public int getC_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CIN.
		@param cin_no CIN	  */
	public void setcin_no (String cin_no)
	{
		set_Value (COLUMNNAME_cin_no, cin_no);
	}

	/** Get CIN.
		@return CIN	  */
	public String getcin_no () 
	{
		return (String)get_Value(COLUMNNAME_cin_no);
	}

	/** Set Description.
		@param Description 
		description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set GSTIN.
		@param gstin_code GSTIN	  */
	public void setgstin_code (String gstin_code)
	{
		set_Value (COLUMNNAME_gstin_code, gstin_code);
	}

	/** Get GSTIN.
		@return GSTIN	  */
	public String getgstin_code () 
	{
		return (String)get_Value(COLUMNNAME_gstin_code);
	}

	/** Set Organization Statutory Details.
		@param IND_Statutory_Org_ID Organization Statutory Details	  */
	public void setIND_Statutory_Org_ID (int IND_Statutory_Org_ID)
	{
		if (IND_Statutory_Org_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_IND_Statutory_Org_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_IND_Statutory_Org_ID, Integer.valueOf(IND_Statutory_Org_ID));
	}

	/** Get Organization Statutory Details.
		@return Organization Statutory Details	  */
	public int getIND_Statutory_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IND_Statutory_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Ind_Statutory_Org_UU.
		@param Ind_Statutory_Org_UU Ind_Statutory_Org_UU	  */
	public void setInd_Statutory_Org_UU (String Ind_Statutory_Org_UU)
	{
		set_Value (COLUMNNAME_Ind_Statutory_Org_UU, Ind_Statutory_Org_UU);
	}

	/** Get Ind_Statutory_Org_UU.
		@return Ind_Statutory_Org_UU	  */
	public String getInd_Statutory_Org_UU () 
	{
		return (String)get_Value(COLUMNNAME_Ind_Statutory_Org_UU);
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

	public I_Ind_Tax_Entity_Type getInd_Tax_Entity_Type() throws RuntimeException
    {
		return (I_Ind_Tax_Entity_Type)MTable.get(getCtx(), I_Ind_Tax_Entity_Type.Table_Name)
			.getPO(getInd_Tax_Entity_Type_ID(), get_TrxName());	}

	/** Set Tax Entity Types.
		@param Ind_Tax_Entity_Type_ID 
		Entity type as per tax law
	  */
	public void setInd_Tax_Entity_Type_ID (int Ind_Tax_Entity_Type_ID)
	{
		if (Ind_Tax_Entity_Type_ID < 1) 
			set_Value (COLUMNNAME_Ind_Tax_Entity_Type_ID, null);
		else 
			set_Value (COLUMNNAME_Ind_Tax_Entity_Type_ID, Integer.valueOf(Ind_Tax_Entity_Type_ID));
	}

	/** Get Tax Entity Types.
		@return Entity type as per tax law
	  */
	public int getInd_Tax_Entity_Type_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ind_Tax_Entity_Type_ID);
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

	/** Set PAN.
		@param pan_no 
		Indian PAN Number
	  */
	public void setpan_no (String pan_no)
	{
		set_Value (COLUMNNAME_pan_no, pan_no);
	}

	/** Get PAN.
		@return Indian PAN Number
	  */
	public String getpan_no () 
	{
		return (String)get_Value(COLUMNNAME_pan_no);
	}

	/** Set TAN.
		@param tan_no TAN	  */
	public void settan_no (String tan_no)
	{
		set_Value (COLUMNNAME_tan_no, tan_no);
	}

	/** Get TAN.
		@return TAN	  */
	public String gettan_no () 
	{
		return (String)get_Value(COLUMNNAME_tan_no);
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