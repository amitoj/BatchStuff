package it.scompo.batchstuff.batch.tumblr.load.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tumblr.jumblr.types.Blog;

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
	public Step tumblrLoadBlogsStep() {

		return stepBuilderFactory.get(NAME)
				.<Blog, PersistableBlog> chunk(CHUNK_SIZE).faultTolerant()
				.reader(tumblrLoadBlogsReader())
				.processor(tumblrLoadBlogsProcessor())
				.writer(tumblrLoadBlogsWriter()).build();
	}

	@Bean(name = NAME_READER)
	public ItemReader<? extends Blog> tumblrLoadBlogsReader() {

		return new TumblrLoadBlogsReader();
	}

	@Bean(name = NAME_PROCESSOR)
	public ItemProcessor<? super Blog, ? extends PersistableBlog> tumblrLoadBlogsProcessor() {

		return new TumblrLoadBlogsProcessor();
	}

	@Bean(name = NAME_WRITER)
	public ItemWriter<? super PersistableBlog> tumblrLoadBlogsWriter() {

		return new TumblrLoadBlogsWriter();
	}
}
