package it.scompo.batchstuff.batch.conditional.steps.configuration;

import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.configurations.beans.ConfigurationBuilder;
import it.scompo.batchstuff.api.configurations.services.ConfigurationService;
import it.scompo.batchstuff.api.executions.beans.Execution;
import it.scompo.batchstuff.api.executions.beans.ExecutionStaticFactory;
import it.scompo.batchstuff.api.executions.services.ExecutionService;
import it.scompo.batchstuff.utils.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ConfigurationTaskletImpl implements ConfigurationTasklet {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigurationTaskletImpl.class);

	@Autowired
	private ExecutionService executionService;

	@Autowired
	private ConfigurationService configurationService;

	private Long numbersToCreate;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		Execution execution = null;

		Configuration configuration = null;

		execution = ExecutionStaticFactory.create(DateUtils.getCurrentDate());

		executionService.save(execution);

		configuration = buildConfiguration(execution);

		configurationService.save(configuration);

		logger.debug("saved: " + configuration);

		return RepeatStatus.FINISHED;
	}

	private Configuration buildConfiguration(Execution execution) {

		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(
				execution);

		return configurationBuilder.numbersToCreate(numbersToCreate).build();
	}

	public Long getNumbersToCreate() {
		return numbersToCreate;
	}

	@Value(value = "#{jobParameters['numbersToCreate']}")
	public void setNumbersToCreate(Long numbersToCreate) {
		this.numbersToCreate = numbersToCreate;
	}

}
