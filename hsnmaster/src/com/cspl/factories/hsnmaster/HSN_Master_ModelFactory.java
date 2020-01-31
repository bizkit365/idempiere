package com.cspl.factories.hsnmaster;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;
import com.cspl.hsnmaster.*;

public class HSN_Master_ModelFactory implements IModelFactory
{

	@Override
	public Class<?> getClass(String tableName) 
	{
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) 
	{
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) 
	{
		return null;
	}
	
}
