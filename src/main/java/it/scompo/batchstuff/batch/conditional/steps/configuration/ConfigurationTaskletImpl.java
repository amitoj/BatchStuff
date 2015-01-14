package it.scompo.batchstuff.batch.conditional.steps.configuration;

import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.configurations.beans.ConfigurationStaticFactory;
import it.scompo.batchstuff.api.configurations.services.ConfigurationService;
import it.scompo.batchstuff.api.executions.beans.Execution;
import it.scompo.batchstuff.api.executions.beans.ExecutionStaticFactory;
import it.scompo.batchstuff.api.executions.services.ExecutionService;
import it.scompo.batchstuff.batch.commons.CopyStepExecutionListener;
import it.scompo.batchstuff.batch.conditional.ConditionalJobConfiguration.Steps;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationTaskletImpl implements ConfigurationTasklet {
	
	private CopyStepExecutionListener stepExecutionCopyListener = new CopyStepExecutionListener();

	@Autowired
	private ExecutionService executionService;

	@Autowired
	private ConfigurationService configurationService;

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigurationTaskletImpl.class);

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		Execution execution = null;

		Configuration configuration = null;

		Long numStep1 = null;
		Long numStep2 = null;
		Long numStep3 = null;

		numStep1 = getNumFromContext(chunkContext, Steps.STEP_1);
		numStep2 = getNumFromContext(chunkContext, Steps.STEP_2);
		numStep3 = getNumFromContext(chunkContext, Steps.STEP_3);

		execution = ExecutionStaticFactory.create(getCurrentDate());

		executionService.save(execution);

		configuration = ConfigurationStaticFactory.create(execution, numStep1,
				numStep2, numStep3);

		configurationService.save(configuration);

		logger.debug("saved: " + configuration);

		return RepeatStatus.FINISHED;
	}

	private static Long getNumFromContext(ChunkContext chunkContext, Steps step) {

		Long res = null;

		res = chunkContext.getStepContext().getStepExecution()
				.getExecutionContext().getLong(step.getNumParameterName());

		return res;
	}

	private static Date getCurrentDate() {

		return new Date();
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {

		stepExecutionCopyListener.beforeStep(stepExecution);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		return stepExecutionCopyListener.afterStep(stepExecution);
	}

}
