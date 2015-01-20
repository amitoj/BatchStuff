package it.scompo.batchstuff.batch.tumblr.load.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;
import it.scompo.batchstuff.api.tumblr.client.SpringTumblrClient;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.tumblr.jumblr.types.Blog;

public class TumblrLoadBlogsProcessor implements
		ItemProcessor<PersistableBlog, PersistableBlog> {

	@Autowired
	private SpringTumblrClient springTumblrClient;

	@Override
	public PersistableBlog process(PersistableBlog item) throws Exception {

		Blog blog = springTumblrClient.blogInfo(item.getUrl());

		item.addFields(blog);

		return item;
	}

}
