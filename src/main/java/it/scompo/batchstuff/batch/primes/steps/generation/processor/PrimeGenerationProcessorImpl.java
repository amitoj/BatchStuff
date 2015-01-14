package it.scompo.batchstuff.batch.primes.steps.generation.processor;

import java.math.BigInteger;

import org.springframework.batch.item.validator.ValidatingItemProcessor;


public class PrimeGenerationProcessorImpl extends
		ValidatingItemProcessor<BigInteger> implements PrimeGenerationProcessor {

}
