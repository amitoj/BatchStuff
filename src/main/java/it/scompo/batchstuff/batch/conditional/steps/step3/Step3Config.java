package it.scompo.batchstuff.batch.conditional.steps.step3;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step3Config {

	public static final String NAME = "conditionalStep3";
	
	@Autowired
	private Step3Tasklet step3Tasklet;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = NAME)
	public Step step3() {
		return stepBuilderFactory.get(NAME)
				.tasklet(step3Tasklet).build();
	}
}
