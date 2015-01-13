package it.scompo.batchstuff.batch.conditional;

import it.scompo.batchstuff.batch.conditional.steps.configuration.ConfigurationStepConfig;
import it.scompo.batchstuff.batch.conditional.steps.report.ReportStepConfig;
import it.scompo.batchstuff.batch.conditional.steps.step1.Step1Config;
import it.scompo.batchstuff.batch.conditional.steps.step2.Step2Config;
import it.scompo.batchstuff.batch.conditional.steps.step3.Step3Config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalJobConfiguration {

	public static final int DEFAULT_CHUNK_SIZE = 1;

	public static final String JOB_NAME = "conditionalJob";

	public enum Steps {

		STEP_1("step1.num", "step1.conf"), STEP_2("step2.num", "step2.conf"), STEP_3(
				"step3.num", "step3.conf"), ;

		private String configurationName;
		private String numParameterName;

		private Steps(String numParameterName, String configurationName) {
			this.numParameterName = numParameterName;
			this.configurationName = configurationName;
		}

		public String getNumParameterName() {
			return numParameterName;
		}

		public String getConfigurationName() {
			return configurationName;
		}

	}

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier(ConfigurationStepConfig.NAME)
	private Step configurationStep;

	@Autowired
	@Qualifier(ReportStepConfig.NAME)
	private Step reportStep;

	@Autowired
	@Qualifier(Step1Config.NAME)
	private Step step1;

	@Autowired
	@Qualifier(Step2Config.NAME)
	private Step step2;

	@Autowired
	@Qualifier(Step3Config.NAME)
	private Step step3;

	@Bean(name = JOB_NAME)
	public Job conditionalJob() {

		return jobBuilderFactory.get(JOB_NAME).start(configurationStep)
				.next(step1).next(step2).next(step3).next(reportStep).build();
	}

}
