package it.scompo.batchstuff.api.configurations.beans;

import java.io.Serializable;

import it.scompo.batchstuff.api.executions.beans.Execution;

public class Configuration implements Serializable {

	private static final long serialVersionUID = -3821209604996423729L;

	private Execution execution;

	private Long numbersToCreate;

	protected Configuration() {
		
	}

	public Execution getExecution() {
		return execution;
	}

	public void setExecution(Execution execution) {
		this.execution = execution;
	}

	public Long getNumbersToCreate() {
		return numbersToCreate;
	}

	public void setNumbersToCreate(Long numbersToCreate) {
		this.numbersToCreate = numbersToCreate;
	}

	@Override
	public String toString() {
		return "Configuration [execution=" + execution + ", numbersToCreate="
				+ numbersToCreate + "]";
	}
}
