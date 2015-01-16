package it.scompo.batchstuff.batch.tumblr.load.users;

import it.scompo.batchstuff.api.tumblr.beans.PersistableUser;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tumblr.jumblr.types.User;

@Configuration
public class TumblrLoadUserStepConfiguration {

	public static final String NAME = "tumblrLoadUsersStep";

	public static final String NAME_READER = NAME + "Reader";
	public static final String NAME_PROCESSOR = NAME + "Processor";
	public static final String NAME_WRITER = NAME + "Writer";

	private static final int CHUNK_SIZE = 10;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = NAME)
	public Step tumblrLoadUserStep() {

		return stepBuilderFactory.get(NAME)
				.<User, PersistableUser> chunk(CHUNK_SIZE).faultTolerant()
				.reader(tumblrLoadUsersReader())
				.processor(tumblrLoadUsersProcessor())
				.writer(tumblrLoadUsersWriter()).build();
	}

	@Bean(name = NAME_READER)
	public ItemReader<? extends User> tumblrLoadUsersReader() {
		
		return new TumblrLoadUserReader();
	}

	@Bean(name = NAME_PROCESSOR)
	public ItemProcessor<? super User, ? extends PersistableUser> tumblrLoadUsersProcessor() {
		
		return new TumblrLoadUserProcessor();
	}

	@Bean(name = NAME_WRITER)
	public ItemWriter<? super PersistableUser> tumblrLoadUsersWriter() {

		return new TumblrLoadUserWriter();
	}

}
