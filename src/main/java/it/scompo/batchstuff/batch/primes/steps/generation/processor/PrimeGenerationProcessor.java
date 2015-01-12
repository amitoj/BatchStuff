package it.scompo.batchstuff.batch.primes.steps.generation.processor;

import java.math.BigInteger;

import org.springframework.batch.item.ItemProcessor;

public interface PrimeGenerationProcessor extends
		ItemProcessor<BigInteger, BigInteger> {

}
