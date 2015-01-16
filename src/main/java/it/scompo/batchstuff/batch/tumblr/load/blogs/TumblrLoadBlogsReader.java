package it.scompo.batchstuff.batch.tumblr.load.blogs;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.tumblr.jumblr.types.Blog;

public class TumblrLoadBlogsReader implements ItemReader<Blog> {

	@Override
	public Blog read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
