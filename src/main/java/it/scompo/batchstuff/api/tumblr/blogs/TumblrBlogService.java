package it.scompo.batchstuff.api.tumblr.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;

import java.util.List;

public interface TumblrBlogService {

	List<PersistableBlog> getAllBlogs();

}
