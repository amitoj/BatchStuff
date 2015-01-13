package it.scompo.batchstuff.batch.conditional.steps.report;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportStepConfig {

	public static final String NAME = "conditionalReportStep";

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ReportTasklet reportTasklet;
	
	@Bean(name = NAME)
	public Step reportStep() {
		return stepBuilderFactory.get(NAME)
				.tasklet(reportTasklet).build();
	}
}
