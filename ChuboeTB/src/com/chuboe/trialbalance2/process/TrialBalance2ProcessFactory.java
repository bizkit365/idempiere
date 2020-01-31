package com.chuboe.trialbalance2.process;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class TrialBalance2ProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		if(className.equals(CreateTrialBalanceDetails.class.getName())) {
			return new CreateTrialBalanceDetails();
		}
		return null;
	}

}
