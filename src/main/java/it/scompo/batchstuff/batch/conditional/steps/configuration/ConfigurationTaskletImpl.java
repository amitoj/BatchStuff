package it.scompo.batchstuff.batch.conditional.steps.configuration;

import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.configurations.beans.ConfigurationStaticFactory;
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

	private Long numStep1;
	private Long numStep2;
	private Long numStep3;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		Execution execution = null;

		Configuration configuration = null;

		execution = ExecutionStaticFactory.create(DateUtils.getCurrentDate());

		executionService.save(execution);

		configuration = ConfigurationStaticFactory.create(execution, numStep1,
				numStep2, numStep3);

		configurationService.save(configuration);

		logger.debug("saved: " + configuration);

		return RepeatStatus.FINISHED;
	}

	public Long getNumStep1() {
		return numStep1;
	}

	@Value(value = "#{jobParameters['step1.num']}")
	public void setNumStep1(Long numStep1) {
		this.numStep1 = numStep1;
	}

	public Long getNumStep2() {
		return numStep2;
	}

	@Value(value = "#{jobParameters['step2.num']}")
	public void setNumStep2(Long numStep2) {
		this.numStep2 = numStep2;
	}

	public Long getNumStep3() {
		return numStep3;
	}

	@Value(value = "#{jobParameters['step3.num']}")
	public void setNumStep3(Long numStep3) {
		this.numStep3 = numStep3;
	}

}
