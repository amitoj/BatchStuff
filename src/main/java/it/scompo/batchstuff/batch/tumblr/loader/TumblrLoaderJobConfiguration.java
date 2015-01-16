package it.scompo.batchstuff.batch.tumblr.loader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TumblrLoaderJobConfiguration {

	public static final String JOB_NAME = "tumblrJobName";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private Step tumblrLoadUserStep;

	@Autowired
	private Step tumblrLoadBlogsStep;

	@Autowired
	private Step tumblrLoadPostsStep;

	public Job tumblrJob() {

		return jobBuilderFactory.get(JOB_NAME).start(tumblrLoadUserStep)
				.next(tumblrLoadBlogsStep).next(tumblrLoadPostsStep).build();
	}
}
