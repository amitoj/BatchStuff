package it.scompo.batchstuff.api.tumblr.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;

@Service
@Transactional
public class TumblrPostsBusinessService implements TumblrPostService {

	@Autowired
	private TumblrPostsDao tumblrPostDao;

	@Override
	public List<PersistablePost> getAllPosts() {
		
		return tumblrPostDao.getAllPosts();
	}

}
