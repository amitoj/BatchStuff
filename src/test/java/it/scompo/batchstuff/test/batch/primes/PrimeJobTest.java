package it.scompo.batchstuff.test.batch.primes;

import static org.junit.Assert.assertEquals;
import static it.scompo.batchstuff.batch.primes.PrimeJobConstants.*;

import java.util.HashMap;
import java.util.Map;

import it.scompo.batchstuff.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PrimeJobTest {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier(PRIME_JOB_NAME)
	private Job jobPrime;

	@Test
	public void testRunPrimeJob() throws Exception {

		JobExecution res = null;

		Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		
		map.put(PRIME_GENERATION_START_NUMBER_PARAM_NAME, new JobParameter("1"));
		map.put(PRIME_GENERATION_STOP_NUMBER_PARAM_NAME, new JobParameter("1000"));
		
		
		JobParameters jobParameters = new JobParameters(map);
		
		res = jobLauncher.run(jobPrime, jobParameters);
		
		assertEquals(ExitStatus.COMPLETED, res.getExitStatus());
	}

}
