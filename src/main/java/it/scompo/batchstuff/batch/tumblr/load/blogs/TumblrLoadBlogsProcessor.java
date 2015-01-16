package it.scompo.batchstuff.batch.tumblr.load.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;

import org.springframework.batch.item.ItemProcessor;

import com.tumblr.jumblr.types.Blog;

public class TumblrLoadBlogsProcessor implements
		ItemProcessor<Blog, PersistableBlog> {

	@Override
	public PersistableBlog process(Blog item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
