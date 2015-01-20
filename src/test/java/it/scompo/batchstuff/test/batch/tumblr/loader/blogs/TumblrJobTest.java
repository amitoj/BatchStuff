package it.scompo.batchstuff.test.batch.tumblr.loader.blogs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import it.scompo.batchstuff.Application;
import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;
import it.scompo.batchstuff.api.tumblr.posts.TumblrPostService;
import it.scompo.batchstuff.batch.tumblr.load.TumblrLoaderJobConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
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
@Ignore("not sharing my data so it would not work on ci..")
public class TumblrJobTest {

	@Autowired
	private TumblrPostService tumblrPostService;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier(TumblrLoaderJobConfiguration.JOB_NAME)
	private Job jobTumblrLoad;

	@Test
	public void testRunTumblrJob() throws Exception {

		JobExecution res = null;

		Map<String, JobParameter> map = new HashMap<String, JobParameter>();

		map.put("pathToFile", new JobParameter("test.txt"));

		JobParameters jobParameters = new JobParameters(map);

		res = jobLauncher.run(jobTumblrLoad, jobParameters);

		assertEquals(ExitStatus.COMPLETED, res.getExitStatus());

		List<PersistablePost> posts = tumblrPostService.getAllPosts();

		assertFalse(posts.isEmpty());
	}

}
