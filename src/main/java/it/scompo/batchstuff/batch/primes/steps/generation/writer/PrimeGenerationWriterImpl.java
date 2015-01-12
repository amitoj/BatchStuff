package it.scompo.batchstuff.batch.primes.steps.generation.writer;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PrimeGenerationWriterImpl implements PrimeGenerationWriter {

	private static final Logger logger = LoggerFactory
			.getLogger(PrimeGenerationWriterImpl.class);

	@Override
	public void write(List<? extends BigInteger> items) throws Exception {

		logger.info("Writing " + items.size() + " primes");

		for (BigInteger bigInteger : items) {
			logger.debug("NUM= " + bigInteger);
		}
	}

}
