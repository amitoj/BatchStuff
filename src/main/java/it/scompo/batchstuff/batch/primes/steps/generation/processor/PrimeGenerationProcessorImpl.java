package it.scompo.batchstuff.batch.primes.steps.generation.processor;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class PrimeGenerationProcessorImpl implements PrimeGenerationProcessor {

	@Override
	public BigInteger process(BigInteger item) throws Exception {

		if (!item.isProbablePrime(100)) {

			throw new IllegalArgumentException("is not prime!");
		}

		return item;
	}

}
