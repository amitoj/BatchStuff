package it.scompo.batchstuff.batch.nothing;

import static it.scompo.batchstuff.batch.nothing.NothingConstants.*;

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

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private Tasklet nothingOnlyStepTasklet;

	@Bean
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
