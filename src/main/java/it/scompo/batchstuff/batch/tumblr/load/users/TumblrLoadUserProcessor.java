package it.scompo.batchstuff.batch.tumblr.load.users;

import it.scompo.batchstuff.api.tumblr.beans.PersistableUser;

import org.springframework.batch.item.ItemProcessor;

import com.tumblr.jumblr.types.User;

public class TumblrLoadUserProcessor implements
		ItemProcessor<User, PersistableUser> {

	@Override
	public PersistableUser process(User item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
