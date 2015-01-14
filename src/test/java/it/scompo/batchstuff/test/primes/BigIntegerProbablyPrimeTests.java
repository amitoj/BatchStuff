package it.scompo.batchstuff.test.primes;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class BigIntegerProbablyPrimeTests {

	@Test
	public void testPrime() {
		
		assertFalse(BigInteger.ONE.isProbablePrime(1));
		
	}
	
	@Test
	public void testCarmichael() {
		
		assertFalse(new BigInteger("561").isProbablePrime(Integer.MAX_VALUE));
		assertFalse(new BigInteger("1729").isProbablePrime(Integer.MAX_VALUE));
		assertTrue(new BigInteger("32416190039").isProbablePrime(Integer.MAX_VALUE));
		
	}

}
