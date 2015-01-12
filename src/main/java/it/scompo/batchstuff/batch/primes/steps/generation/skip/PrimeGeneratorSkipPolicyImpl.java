package it.scompo.batchstuff.batch.primes.steps.generation.skip;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.stereotype.Component;

@Component
public class PrimeGeneratorSkipPolicyImpl implements PrimeGeneratorSkipPolicy {

	@Override
	public boolean shouldSkip(Throwable t, int skipCount)
			throws SkipLimitExceededException {

		if (t.getMessage().contains("prime")) {

			return true;
		}

		return false;
	}

}
