package it.scompo.batchstuff.batch.tumblr.load.posts;

import java.util.List;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;

import org.springframework.batch.item.ItemWriter;

public class TumblrLoadPostWriter implements ItemWriter<PersistablePost> {

	@Override
	public void write(List<? extends PersistablePost> items) throws Exception {
		// TODO Auto-generated method stub

	}

}
