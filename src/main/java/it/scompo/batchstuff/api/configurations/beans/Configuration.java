package it.scompo.batchstuff.api.configurations.beans;

import java.io.Serializable;

import it.scompo.batchstuff.api.executions.beans.Execution;

public class Configuration implements Serializable {

	private static final long serialVersionUID = -3821209604996423729L;

	private Execution execution;

	private Long numStep1;

	private Long numStep2;

	private Long numStep3;

	public Configuration() {

	}

	public Execution getExecution() {
		return execution;
	}

	public void setExecution(Execution execution) {
		this.execution = execution;
	}

	public Long getNumStep1() {
		return numStep1;
	}

	public void setNumStep1(Long numStep1) {
		this.numStep1 = numStep1;
	}

	public Long getNumStep2() {
		return numStep2;
	}

	public void setNumStep2(Long numStep2) {
		this.numStep2 = numStep2;
	}

	public Long getNumStep3() {
		return numStep3;
	}

	public void setNumStep3(Long numStep3) {
		this.numStep3 = numStep3;
	}

	@Override
	public String toString() {
		return "Configuration [execution=" + execution + ", numStep1="
				+ numStep1 + ", numStep2=" + numStep2 + ", numStep3="
				+ numStep3 + "]";
	}

}
