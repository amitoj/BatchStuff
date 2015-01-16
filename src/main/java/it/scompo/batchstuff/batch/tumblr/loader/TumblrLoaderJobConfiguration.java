package it.scompo.batchstuff.batch.tumblr.loader;

import it.scompo.batchstuff.batch.tumblr.load.blogs.TumblrLoadBlogsConfiguration;
import it.scompo.batchstuff.batch.tumblr.load.posts.TumblrLoadPostsConfiguration;
import it.scompo.batchstuff.batch.tumblr.load.users.TumblrLoadUserStepConfiguration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TumblrLoaderJobConfiguration {

	public static final String JOB_NAME = "tumblrJobName";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	@Qualifier(TumblrLoadUserStepConfiguration.NAME)
	private Step tumblrLoadUserStep;

	@Autowired
	@Qualifier(TumblrLoadBlogsConfiguration.NAME)
	private Step tumblrLoadBlogsStep;

	@Autowired
	@Qualifier(TumblrLoadPostsConfiguration.NAME)
	private Step tumblrLoadPostsStep;

	public Job tumblrJob() {

		return jobBuilderFactory.get(JOB_NAME).start(tumblrLoadUserStep)
				.next(tumblrLoadBlogsStep).next(tumblrLoadPostsStep).build();
	}
}
