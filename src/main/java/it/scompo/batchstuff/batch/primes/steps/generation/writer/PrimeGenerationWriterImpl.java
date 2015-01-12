package it.scompo.batchstuff.batch.primes.steps.generation.writer;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PrimeGenerationWriterImpl implements PrimeGenerationWriter {

	@Override
	public void write(List<? extends BigInteger> items) throws Exception {

		System.err.println("Size=" + items.size());

		for (BigInteger bigInteger : items) {
			System.err.println("NUM= " + bigInteger);
		}
	}

}
