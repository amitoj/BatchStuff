package it.scompo.batchstuff.test.batch.nothing;

import static org.junit.Assert.assertEquals;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.batch.nothing.NothingJobConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NothingJobTest {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier(NothingJobConfiguration.NOTHING_JOB_NAME)
	private Job jobDoNothing;

	@Test
	public void testRunDoNothing() throws Exception {

		JobExecution res = null;

		res = jobLauncher.run(jobDoNothing, new JobParameters());
		
		assertEquals(ExitStatus.COMPLETED, res.getExitStatus());
	}

}
