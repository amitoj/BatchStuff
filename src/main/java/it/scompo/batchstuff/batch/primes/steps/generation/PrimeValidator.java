package it.scompo.batchstuff.batch.primes.steps.generation;

import java.math.BigInteger;

import org.springframework.batch.item.validator.Validator;

public interface PrimeValidator extends Validator<BigInteger> {

}
