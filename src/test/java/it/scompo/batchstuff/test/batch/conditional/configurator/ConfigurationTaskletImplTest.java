package it.scompo.batchstuff.test.batch.conditional.configurator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.configurations.services.ConfigurationService;
import it.scompo.batchstuff.batch.conditional.ConditionalJobConfiguration.Steps;
import it.scompo.batchstuff.batch.conditional.steps.configuration.ConfigurationTasklet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ConfigurationTaskletImplTest {

	private static final Long DEFAULT_VALUE = 10L;

	@Autowired
	private ConfigurationTasklet configurationTasklet;

	@Autowired
	private ConfigurationService configurationService;

	public StepExecution getStepExecution() {

		StepExecution step = null;

		step = MetaDataInstanceFactory.createStepExecution();

		ExecutionContext executionContext = step.getExecutionContext();

		executionContext.putLong(Steps.STEP_1.getNumParameterName(),
				DEFAULT_VALUE);
		executionContext.putLong(Steps.STEP_2.getNumParameterName(),
				DEFAULT_VALUE);
		executionContext.putLong(Steps.STEP_3.getNumParameterName(),
				DEFAULT_VALUE);

		return step;
	}

	@Test
	public void testExecute() throws Exception {

		RepeatStatus res = null;

		Configuration configurationSaved = null;

		StepExecution stepExecution = getStepExecution();

		StepContribution contribution = stepExecution.createStepContribution();

		ChunkContext chunkContext = new ChunkContext(new StepContext(
				stepExecution));

		res = configurationTasklet.execute(contribution, chunkContext);

		assertEquals(RepeatStatus.FINISHED, res);

		configurationSaved = configurationService.getLastConfiguration();

		assertNotNull(configurationSaved.getExecution());

		assertEquals(DEFAULT_VALUE, configurationSaved.getNumStep1());
		assertEquals(DEFAULT_VALUE, configurationSaved.getNumStep2());
		assertEquals(DEFAULT_VALUE, configurationSaved.getNumStep3());
	}

}
