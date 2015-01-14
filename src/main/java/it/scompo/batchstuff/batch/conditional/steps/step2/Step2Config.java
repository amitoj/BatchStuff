package it.scompo.batchstuff.batch.conditional.steps.step2;

import it.scompo.batchstuff.batch.conditional.ConditionalJobConfiguration;
import it.scompo.batchstuff.batch.conditional.steps.step2.processor.Step2Processor;
import it.scompo.batchstuff.batch.conditional.steps.step2.reader.Step2Reader;
import it.scompo.batchstuff.batch.conditional.steps.step2.writer.Step2Writer;

import java.math.BigInteger;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step2Config {

	public static final String NAME = "conditionalStep2";

	private static final int CHUNK_SIZE = ConditionalJobConfiguration.DEFAULT_CHUNK_SIZE;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private Step2Reader step2Reader;

	@Autowired
	private Step2Processor step2Processor;

	@Autowired
	private Step2Writer step2Writer;

	@Bean(name = NAME)
	public Step step2() {

		return stepBuilderFactory.get(NAME)
				.<BigInteger, BigInteger> chunk(CHUNK_SIZE).faultTolerant()
				.reader(step2Reader).processor(step2Processor)
				.writer(step2Writer).build();
	}
}
