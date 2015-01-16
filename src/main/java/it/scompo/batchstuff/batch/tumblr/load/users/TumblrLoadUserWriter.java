package it.scompo.batchstuff.batch.tumblr.load.users;

import java.util.List;

import it.scompo.batchstuff.api.tumblr.beans.PersistableUser;

import org.springframework.batch.item.ItemWriter;

public class TumblrLoadUserWriter implements
		ItemWriter<PersistableUser> {

	@Override
	public void write(List<? extends PersistableUser> items) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
