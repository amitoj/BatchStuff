package it.scompo.batchstuff.test.batch.primes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.batch.primes.PrimeJobConfiguration;
import it.scompo.batchstuff.batch.primes.steps.generation.reader.PrimeGenerationReader;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ContextConfiguration(classes = { Application.class })
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		StepScopeTestExecutionListener.class })
public class PrimeGenerationReaderImplTest {

	public StepExecution getStepExecution() {

		StepExecution step = null;

		Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();

		parameters.put(
				PrimeJobConfiguration.PRIME_GENERATION_START_NUMBER_PARAM_NAME,
				new JobParameter("0"));
		parameters.put(
				PrimeJobConfiguration.PRIME_GENERATION_STOP_NUMBER_PARAM_NAME,
				new JobParameter("10"));

		JobParameters params = new JobParameters(parameters);

		step = MetaDataInstanceFactory.createStepExecution(params);

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
