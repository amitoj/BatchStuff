package it.scompo.batchstuff.batch.tumblr.load.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;
import it.scompo.batchstuff.utils.ObjectSerializationUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class TumblrLoadBlogsConfiguration {

	public static final String NAME = "tumblrLoadBlogsStep";
	public static final String NAME_READER = NAME + "Reader";
	public static final String NAME_PROCESSOR = NAME + "Processor";
	public static final String NAME_WRITER = NAME + "Writer";

	private static final int CHUNK_SIZE = 10;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = NAME)
	public Step tumblrLoadBlogsStep(
			ItemReader<PersistableBlog> itemReader,
			ItemWriter<PersistableBlog> tumblrLoadBlogsWriter) {

		return stepBuilderFactory.get(NAME)
				.<PersistableBlog, PersistableBlog> chunk(CHUNK_SIZE)
				.faultTolerant().reader(itemReader)
				.processor(tumblrLoadBlogsProcessor())
				.writer(tumblrLoadBlogsWriter).build();
	}

	@Bean
	@StepScope
	public FlatFileItemReader<PersistableBlog> reader(
			@Value("#{jobParameters['pathToFile']}") String pathToFile) {

		FlatFileItemReader<PersistableBlog> itemReader = new FlatFileItemReader<PersistableBlog>();

		itemReader.setLineMapper(lineMapper());
		itemReader.setResource(new ClassPathResource(pathToFile));

		return itemReader;
	}

	@Bean
	public LineMapper<PersistableBlog> lineMapper() {

		DefaultLineMapper<PersistableBlog> lineMapper = new DefaultLineMapper<PersistableBlog>();

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

		tokenizer.setNames(new String[] { "id", "url" });

		BeanWrapperFieldSetMapper<PersistableBlog> fieldSetMapper = new BeanWrapperFieldSetMapper<PersistableBlog>();
		fieldSetMapper.setTargetType(PersistableBlog.class);

		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	@Bean(name = NAME_PROCESSOR)
	public ItemProcessor<? super PersistableBlog, ? extends PersistableBlog> tumblrLoadBlogsProcessor() {

		return new TumblrLoadBlogsProcessor();
	}

	@Bean(name = NAME_WRITER)
	public JdbcBatchItemWriter<PersistableBlog> tumblrLoadBlogsWriter(
			DataSource dataSource) {

		JdbcBatchItemWriter<PersistableBlog> jdbcBatchItemWriter = new JdbcBatchItemWriter<PersistableBlog>();

		jdbcBatchItemWriter.setDataSource(dataSource);
		jdbcBatchItemWriter
				.setSql("insert into persistable_blog(id, data) values (?,?)");
		jdbcBatchItemWriter
				.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<PersistableBlog>() {

					@Override
					public void setValues(PersistableBlog item,
							PreparedStatement ps) throws SQLException {

						ps.setLong(1, item.getId());
						ps.setString(2, ObjectSerializationUtils.convertObjectIntoString(item));
					}
				});
		return jdbcBatchItemWriter;
	}
}
