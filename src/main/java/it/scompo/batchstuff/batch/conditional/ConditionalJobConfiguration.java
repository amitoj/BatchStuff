package it.scompo.batchstuff.batch.conditional;

import it.scompo.batchstuff.batch.conditional.steps.configuration.ConfigurationTasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalJobConfiguration {

	public static final String CONDITIONAL_CONFIGURATION_STEP_NAME = "conditionalConfiguration";

	public static final String JOB_NAME = "conditionalJob";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ConfigurationTasklet configurationTasklet;

	@Bean(name = JOB_NAME)
	public Job conditionalJob() {

		return jobBuilderFactory.get(JOB_NAME).start(configurationStep())
				.next(step1()).next(step2()).next(step3()).next(reportStep())
				.build();
	}

	public Step reportStep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	public Step step3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	public Step step2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	public Step step1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	public Step configurationStep() {

		return stepBuilderFactory.get(CONDITIONAL_CONFIGURATION_STEP_NAME)
				.tasklet(configurationTasklet).build();
	}
}
