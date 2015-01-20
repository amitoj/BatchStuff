package it.scompo.batchstuff.api.tumblr.posts;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;

import java.util.List;

public interface TumblrPostService {

	List<PersistablePost> getAllPosts();

}
