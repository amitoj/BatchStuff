package it.scompo.batchstuff.batch.conditional.steps.step1;

import it.scompo.batchstuff.batch.conditional.ConditionalJobConfiguration;
import it.scompo.batchstuff.batch.conditional.steps.step1.listener.Step1Listener;
import it.scompo.batchstuff.batch.conditional.steps.step1.processor.Step1Processor;
import it.scompo.batchstuff.batch.conditional.steps.step1.reader.Step1Reader;
import it.scompo.batchstuff.batch.conditional.steps.step1.writer.Step1Writer;

import java.math.BigInteger;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step1Config {

	public static final String NAME = "conditionalStep1";

	public static final int CHUNK_SIZE = ConditionalJobConfiguration.DEFAULT_CHUNK_SIZE;

	@Autowired
	private Step1Reader step1Reader;

	@Autowired
	private Step1Processor step1Processor;

	@Autowired
	private Step1Writer step1Writer;

	@Autowired
	private Step1Listener step1Listener;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = NAME)
	public Step step1() {

		return stepBuilderFactory.get(NAME)
				.<BigInteger, BigInteger> chunk(CHUNK_SIZE).faultTolerant()
				.reader(step1Reader).processor(step1Processor)
				.writer(step1Writer).listener(step1Listener).build();
	}
}
