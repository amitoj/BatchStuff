package it.scompo.batchstuff.batch.conditional.steps.configuration;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationStepConfig {

	public static final String NAME = "conditionalConfiguration";
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ConfigurationTasklet configurationTasklet;
	
	@Bean(name = NAME)
	public Step configurationStep() {

		return stepBuilderFactory.get(NAME)
				.tasklet(configurationTasklet).build();
	}
}
