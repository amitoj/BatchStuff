package it.scompo.batchstuff.api.configurations.beans;

import it.scompo.batchstuff.api.executions.beans.Execution;

public class ConfigurationBuilder {

	private Configuration configuration;

	public ConfigurationBuilder(Execution execution) {

		configuration = new Configuration();
		configuration.setExecution(execution);
	}

	public ConfigurationBuilder numbersToCreate(Long numbersToCreate) {

		configuration.setNumbersToCreate(numbersToCreate);
		return this;
	}

	public Configuration build() {

		return configuration;
	}

}
