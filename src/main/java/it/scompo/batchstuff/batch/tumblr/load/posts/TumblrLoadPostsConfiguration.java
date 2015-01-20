package it.scompo.batchstuff.batch.tumblr.load.posts;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;
import it.scompo.batchstuff.utils.ObjectSerializationUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TumblrLoadPostsConfiguration {

	public static final String NAME = "tumblrLoadPostsStep";
	public static final String NAME_READER = NAME + "Reader";
	public static final String NAME_PROCESSOR = NAME + "Processor";
	public static final String NAME_WRITER = NAME + "Writer";

	private static final int CHUNK_SIZE = 500;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = NAME)
	public Step tumblrLoadPostStep(
			ItemWriter<PersistablePost> tumblrLoadPostsWriter) {

		return stepBuilderFactory.get(NAME)
				.<PersistablePost, PersistablePost> chunk(CHUNK_SIZE)
				.faultTolerant().reader(tumblrLoadPostsReader())
				.processor(tumblrLoadPostsProcessor())
				.writer(tumblrLoadPostsWriter).build();
	}

	@Bean(name = NAME_READER)
	public ItemReader<? extends PersistablePost> tumblrLoadPostsReader() {
		
		return new TumblrLoadPostReader();
	}

	@Bean(name = NAME_PROCESSOR)
	public ItemProcessor<? super PersistablePost, ? extends PersistablePost> tumblrLoadPostsProcessor() {

		return new TumblrLoadPostProcessor();
	}

	@Bean(name = NAME_WRITER)
	public JdbcBatchItemWriter<PersistablePost> tumblrLoadPostsWriter(
			DataSource dataSource) {

		JdbcBatchItemWriter<PersistablePost> jdbcBatchItemWriter = new JdbcBatchItemWriter<PersistablePost>();

		jdbcBatchItemWriter.setDataSource(dataSource);
		jdbcBatchItemWriter
				.setSql("insert into persistable_post(id, id_blog, data) values (?,?,?)");
		jdbcBatchItemWriter
				.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<PersistablePost>() {

					@Override
					public void setValues(PersistablePost item,
							PreparedStatement ps) throws SQLException {

						ps.setLong(1, item.getId());
						ps.setLong(2, item.getBlogId());
						ps.setString(3, ObjectSerializationUtils
								.convertObjectIntoString(item));
					}
				});

		return jdbcBatchItemWriter;
	}
}
