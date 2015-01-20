package it.scompo.batchstuff.batch.tumblr.load.posts;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;

import org.springframework.batch.item.ItemProcessor;

public class TumblrLoadPostProcessor implements
		ItemProcessor<PersistablePost, PersistablePost> {

	@Override
	public PersistablePost process(PersistablePost item) throws Exception {

		System.err.println(item);
		return item;
	}

}
