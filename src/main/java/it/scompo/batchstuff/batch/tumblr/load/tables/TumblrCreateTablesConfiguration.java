package it.scompo.batchstuff.batch.tumblr.load.tables;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TumblrCreateTablesConfiguration {

	public static final String NAME = "tumblrCreateTables";

	private static final String NAME_TASKLET = NAME + "tasklet";

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;

	@Bean(name = NAME)
	public Step tumblrCreateTables() {

		return stepBuilderFactory.get(NAME_TASKLET)
				.tasklet(tumblrCreateTablesTasklet()).build();
	}

	@Bean(name = NAME_TASKLET)
	public Tasklet tumblrCreateTablesTasklet() {

		TumblrCreateTablesTasklet tumblrCreateTablesTasklet = new TumblrCreateTablesTasklet();

		tumblrCreateTablesTasklet.setDataSource(dataSource);

		return tumblrCreateTablesTasklet;
	}

}
