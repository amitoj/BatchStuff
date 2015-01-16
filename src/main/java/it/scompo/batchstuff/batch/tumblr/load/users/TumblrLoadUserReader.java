package it.scompo.batchstuff.batch.tumblr.load.users;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.tumblr.jumblr.types.User;

public class TumblrLoadUserReader implements ItemReader<User> {

	@Override
	public User read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
