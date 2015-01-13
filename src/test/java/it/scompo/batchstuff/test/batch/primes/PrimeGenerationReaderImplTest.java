package it.scompo.batchstuff.test.batch.primes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.batch.primes.PrimeJobConfiguration;
import it.scompo.batchstuff.batch.primes.steps.generation.reader.PrimeGenerationReader;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PrimeGenerationReaderImplTest {

	public StepExecution getStepExecution() {

		StepExecution step = null;

		step = MetaDataInstanceFactory.createStepExecution();

		step.getExecutionContext().putString(
				PrimeJobConfiguration.PRIME_GENERATION_START_NUMBER_PARAM_NAME, "0");
		step.getExecutionContext().putString(
				PrimeJobConfiguration.PRIME_GENERATION_STOP_NUMBER_PARAM_NAME, "10");

		return step;
	}

	@Autowired
	private PrimeGenerationReader reader;

	@Test
	public void testReadAll() throws Exception {
		
		reader.open(getStepExecution().getExecutionContext());

		for (BigInteger i = BigInteger.ZERO; i.compareTo(new BigInteger("10")) < 0; i = i
				.add(BigInteger.ONE)) {

			assertEquals(i, reader.read());
		}

		assertNull(reader.read());

	}

}
