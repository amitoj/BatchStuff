package it.scompo.batchstuff.api.configurations.services;

import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.executions.beans.Execution;
import it.scompo.batchstuff.api.executions.services.ExecutionService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfigurationBusinessService extends
		HashMap<Execution, Configuration> implements ConfigurationService {

	private static final long serialVersionUID = -8285274128396250536L;
	
	@Autowired
	private ExecutionService executionService;

	public ConfigurationBusinessService() {

		super();
	}

	@Override
	public Configuration save(Configuration configuration) {

		put(configuration.getExecution(), configuration);

		return configuration;
	}

	@Override
	public Configuration getLastConfiguration() {

		return get(executionService.getLastExecution());
	}

}
