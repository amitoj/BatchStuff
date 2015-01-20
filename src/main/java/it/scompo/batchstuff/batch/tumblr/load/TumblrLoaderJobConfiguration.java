package it.scompo.batchstuff.batch.tumblr.load;

import it.scompo.batchstuff.batch.tumblr.load.blogs.TumblrLoadBlogsConfiguration;
import it.scompo.batchstuff.batch.tumblr.load.posts.TumblrLoadPostsConfiguration;
import it.scompo.batchstuff.batch.tumblr.load.tables.TumblrCreateTablesConfiguration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TumblrLoaderJobConfiguration {

	public static final String JOB_NAME = "tumblrJobName";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	@Qualifier(TumblrLoadBlogsConfiguration.NAME)
	private Step tumblrLoadBlogsStep;

	@Autowired
	@Qualifier(TumblrLoadPostsConfiguration.NAME)
	private Step tumblrLoadPostsStep;

	@Autowired
	@Qualifier(TumblrCreateTablesConfiguration.NAME)
	private Step tumblrCreateTables;

	@Bean(name = JOB_NAME)
	public Job tumblrJob() {

		return jobBuilderFactory.get(JOB_NAME).start(tumblrCreateTables).next(tumblrLoadBlogsStep)
				.next(tumblrLoadPostsStep).build();
	}
}
