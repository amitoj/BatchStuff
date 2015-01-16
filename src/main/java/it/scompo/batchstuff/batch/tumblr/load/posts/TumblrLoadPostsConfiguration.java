package it.scompo.batchstuff.batch.tumblr.load.posts;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tumblr.jumblr.types.Post;

@Configuration
public class TumblrLoadPostsConfiguration {

	public static final String NAME = "tumblrLoadPostsStep";
	public static final String NAME_READER = NAME + "Reader";
	public static final String NAME_PROCESSOR = NAME + "Processor";
	public static final String NAME_WRITER = NAME + "Writer";

	private static final int CHUNK_SIZE = 10;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = NAME)
	public Step tumblrLoadPostStep() {

		return stepBuilderFactory.get(NAME)
				.<Post, PersistablePost> chunk(CHUNK_SIZE).faultTolerant()
				.reader(tumblrLoadPostsReader())
				.processor(tumblrLoadPostsProcessor())
				.writer(tumblrLoadPostsWriter()).build();
	}

	@Bean(name = NAME_READER)
	public ItemReader<? extends Post> tumblrLoadPostsReader() {

		return new TumblrLoadPostReader();
	}

	@Bean(name = NAME_PROCESSOR)
	public ItemProcessor<? super Post, ? extends PersistablePost> tumblrLoadPostsProcessor() {

		return new TumblrLoadPostProcessor();
	}

	@Bean(name = NAME_WRITER)
	public ItemWriter<? super PersistablePost> tumblrLoadPostsWriter() {

		return new TumblrLoadPostWriter();
	}
}
