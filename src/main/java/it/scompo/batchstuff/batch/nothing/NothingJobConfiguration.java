package it.scompo.batchstuff.batch.nothing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NothingJobConfiguration {

	public static final String NOTHING_ONLY_STEP_NAME = "nothingOnlyStep";

	public static final String NOTHING_JOB_NAME = "nothingJob";
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private Tasklet nothingOnlyStepTasklet;

	@Bean(name = NOTHING_JOB_NAME)
	public Job doNothingJob() {

		return jobBuilderFactory.get(NOTHING_JOB_NAME).start(nothingOnlyStep())
				.build();
	}

	@Bean
	public Step nothingOnlyStep() {

		return stepBuilderFactory.get(NOTHING_ONLY_STEP_NAME)
				.tasklet(nothingOnlyStepTasklet).build();
	}
}
