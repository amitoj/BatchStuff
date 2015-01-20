package it.scompo.batchstuff.test.batch.conditional.configurator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.api.configurations.beans.Configuration;
import it.scompo.batchstuff.api.configurations.services.ConfigurationService;
import it.scompo.batchstuff.batch.conditional.ConditionalJobConfiguration;
import it.scompo.batchstuff.batch.conditional.steps.configuration.ConfigurationStepConfig;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		StepScopeTestExecutionListener.class })
@ActiveProfiles(profiles = "test")
public class ConfigurationStepTest {

	@Autowired
	@Qualifier(ConditionalJobConfiguration.JOB_NAME)
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobRepository jobRepository;

	public JobLauncherTestUtils jobLauncherTestUtils() {

		JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
		jobLauncherTestUtils.setJob(job);
		jobLauncherTestUtils.setJobLauncher(jobLauncher);
		jobLauncherTestUtils.setJobRepository(jobRepository);

		return jobLauncherTestUtils;
	}

	private static final Long DEFAULT_VALUE = 10L;

	@Autowired
	private ConfigurationService configurationService;

	@Test
	public void test() {

		JobExecution jobExecution = null;

		Configuration configurationSaved = null;

		jobExecution = jobLauncherTestUtils().launchStep(
				ConfigurationStepConfig.NAME, getTestJobParameters());

		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());

		configurationSaved = configurationService.getLastConfiguration();

		assertNotNull(configurationSaved.getExecution());

		assertEquals(DEFAULT_VALUE, configurationSaved.getNumbersToCreate());
	}

	private JobParameters getTestJobParameters() {

		Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();

		parameters.put("numbersToCreate", new JobParameter(DEFAULT_VALUE));

		return new JobParameters(parameters);
	}

}
