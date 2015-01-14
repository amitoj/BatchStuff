package it.scompo.batchstuff.batch.primes;

import it.scompo.batchstuff.batch.primes.steps.generation.PrimeValidator;
import it.scompo.batchstuff.batch.primes.steps.generation.processor.PrimeGenerationProcessor;
import it.scompo.batchstuff.batch.primes.steps.generation.processor.PrimeGenerationProcessorImpl;
import it.scompo.batchstuff.batch.primes.steps.generation.reader.PrimeGenerationReader;
import it.scompo.batchstuff.batch.primes.steps.generation.reader.PrimeGenerationReaderImpl;
import it.scompo.batchstuff.batch.primes.steps.generation.skip.PrimeGeneratorSkipPolicy;
import it.scompo.batchstuff.batch.primes.steps.generation.writer.PrimeGenerationWriter;

import java.math.BigInteger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrimeJobConfiguration {

	public static final String PRIME_JOB_NAME = "primeJob";

	public static final String PRIME_GENERATION_STEP_NAME = "primeGenerationStep";

	public static final int GENERATION_CHUNK_SIZE = 100;

	public static final String PRIME_GENERATION_START_NUMBER_PARAM_NAME = "startNumber";

	public static final String PRIME_GENERATION_STOP_NUMBER_PARAM_NAME = "stopNumber";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private PrimeGenerationWriter primeGenerationWriter;

	@Autowired
	private PrimeGenerationReader primeGenerationReader;

	@Autowired
	private PrimeGeneratorSkipPolicy primeGeneratorSkipPolicy;

	@Autowired
	private PrimeValidator primeValidator;

	@Bean(name = PRIME_JOB_NAME)
	public Job complexJob() {

		return jobBuilderFactory.get(PRIME_JOB_NAME)
				.start(primeGenerationStep()).build();
	}

	@Bean
	public Step primeGenerationStep() {

		return stepBuilderFactory.get(PRIME_GENERATION_STEP_NAME)
				.<BigInteger, BigInteger> chunk(GENERATION_CHUNK_SIZE)
				.faultTolerant().skipPolicy(primeGeneratorSkipPolicy)
				.reader(primeGenerationReader()).processor(primeGeneratorProcessor())
				.writer(primeGenerationWriter).build();
	}

	@Bean
	@StepScope
	public PrimeGenerationReader primeGenerationReader() {

		return new PrimeGenerationReaderImpl();
	}

	@Bean
	public PrimeGenerationProcessor primeGeneratorProcessor() {

		PrimeGenerationProcessorImpl res = new PrimeGenerationProcessorImpl();

		res.setValidator(primeValidator);

		return res;
	}

}
