package it.scompo.batchstuff.batch.tumblr.load.posts;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.tumblr.jumblr.types.Post;

public class TumblrLoadPostReader implements ItemReader<Post> {

	@Override
	public Post read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
