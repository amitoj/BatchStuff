package it.scompo.batchstuff.batch.tumblr.load.blogs;

import java.util.List;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;

import org.springframework.batch.item.ItemWriter;

public class TumblrLoadBlogsWriter implements ItemWriter<PersistableBlog> {

	@Override
	public void write(List<? extends PersistableBlog> items) throws Exception {
		// TODO Auto-generated method stub

	}

}
