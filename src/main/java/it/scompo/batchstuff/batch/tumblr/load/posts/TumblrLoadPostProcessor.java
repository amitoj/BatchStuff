package it.scompo.batchstuff.batch.tumblr.load.posts;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;

import org.springframework.batch.item.ItemProcessor;

import com.tumblr.jumblr.types.Post;

public class TumblrLoadPostProcessor implements
		ItemProcessor<Post, PersistablePost> {

	@Override
	public PersistablePost process(Post item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
