package it.scompo.batchstuff.api.configurations.beans;

import it.scompo.batchstuff.api.executions.beans.Execution;

public abstract class ConfigurationStaticFactory {

	private ConfigurationStaticFactory() {

	}

	public static Configuration create(Execution execution, Long numStep1,
			Long numStep2, Long numStep3) {

		Configuration configuration = new Configuration();

		configuration.setExecution(execution);
		configuration.setNumStep1(numStep1);
		configuration.setNumStep2(numStep2);
		configuration.setNumStep3(numStep3);

		return configuration;
	}

}
