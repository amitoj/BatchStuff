package it.scompo.batchstuff.batch.tumblr.load.tables;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class TumblrCreateTablesTasklet implements Tasklet {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate
				.execute("drop table persistable_blog");
		jdbcTemplate
				.execute("drop table persistable_post");
		jdbcTemplate
				.execute("create table persistable_blog(id bigint, data long varchar)");
		jdbcTemplate
				.execute("create table persistable_post(id bigint, id_blog bigint, data long varchar)");

		return RepeatStatus.FINISHED;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
