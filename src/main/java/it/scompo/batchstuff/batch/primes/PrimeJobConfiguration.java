package it.scompo.batchstuff.batch.primes;

import static it.scompo.batchstuff.batch.primes.PrimeJobConstants.GENERATION_CHUNK_SIZE;
import static it.scompo.batchstuff.batch.primes.PrimeJobConstants.PRIME_GENERATION_STEP_NAME;
import static it.scompo.batchstuff.batch.primes.PrimeJobConstants.PRIME_JOB_NAME;
import it.scompo.batchstuff.batch.primes.steps.generation.listener.PrimeGenerationStepExecutionListener;
import it.scompo.batchstuff.batch.primes.steps.generation.processor.PrimeGenerationProcessor;
import it.scompo.batchstuff.batch.primes.steps.generation.reader.PrimeGenerationReader;
import it.scompo.batchstuff.batch.primes.steps.generation.skip.PrimeGeneratorSkipPolicy;
import it.scompo.batchstuff.batch.primes.steps.generation.writer.PrimeGenerationWriter;

import java.math.BigInteger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrimeJobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private PrimeGenerationProcessor primeGenerationProcessor;

	@Autowired
	private PrimeGenerationWriter primeGenerationWriter;

	@Autowired
	private PrimeGenerationReader primeGenerationReader;

	@Autowired
	private PrimeGeneratorSkipPolicy primeGeneratorSkipPolicy;

	@Autowired
	private PrimeGenerationStepExecutionListener primeGenerationListener;

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
				.reader(primeGenerationReader)
				.processor(primeGenerationProcessor)
				.writer(primeGenerationWriter)
				.listener(primeGenerationListener).build();
	}

}
