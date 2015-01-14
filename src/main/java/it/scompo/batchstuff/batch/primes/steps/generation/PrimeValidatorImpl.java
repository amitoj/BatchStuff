package it.scompo.batchstuff.batch.primes.steps.generation;

import java.math.BigInteger;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class PrimeValidatorImpl implements PrimeValidator {

	@Override
	public void validate(BigInteger value) throws ValidationException {

		if (!value.isProbablePrime(100)) {

			throw new IllegalArgumentException("is not prime!");
		}
	}

}
