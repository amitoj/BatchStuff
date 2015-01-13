package it.scompo.batchstuff.api.executions.beans;

import java.util.Date;

public abstract class ExecutionStaticFactory {

	private ExecutionStaticFactory() {
		
	}
	
	public static Execution create(Date currentDate) {

		Execution execution = new Execution();

		execution.setDate(currentDate);

		return execution;
	}

}
