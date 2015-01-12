package it.scompo.batchstuff.batch.primes;

public abstract class PrimeJobConstants {

	private PrimeJobConstants() {

	}

	public static final String PRIME_JOB_NAME = "primeJob";

	public static final String PRIME_GENERATION_STEP_NAME = "primeGenerationStep";

	public static final int GENERATION_CHUNK_SIZE = 100;

	public static final String PRIME_GENERATION_START_NUMBER_PARAM_NAME = "startNumber";

	public static final String PRIME_GENERATION_STOP_NUMBER_PARAM_NAME = "stopNumber";
}
