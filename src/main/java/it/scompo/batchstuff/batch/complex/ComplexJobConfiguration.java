package it.scompo.batchstuff.batch.complex;

import static it.scompo.batchstuff.batch.complex.ComplexJobConstants.*;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComplexJobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name= COMPLEX_JOB_CONSTANT_NAME)
	public Job complexJob(){
		
		return jobBuilderFactory.get(COMPLEX_JOB_CONSTANT_NAME).start(step1()).build();
	}

	@Bean
	public Step step1() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
