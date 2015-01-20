package it.scompo.batchstuff.api.tumblr.blogs;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TumblrBlogBusinessService implements TumblrBlogService {

	@Autowired
	private TumblrBlogDao tumblrBlogDao;

	@Override
	public List<PersistableBlog> getAllBlogs() {

		return tumblrBlogDao.getAllBlogs();
	}

}
