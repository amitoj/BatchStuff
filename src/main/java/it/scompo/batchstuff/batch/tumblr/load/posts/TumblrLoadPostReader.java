package it.scompo.batchstuff.batch.tumblr.load.posts;

import it.scompo.batchstuff.api.tumblr.beans.PersistableBlog;
import it.scompo.batchstuff.api.tumblr.beans.PersistablePost;
import it.scompo.batchstuff.api.tumblr.blogs.TumblrBlogService;
import it.scompo.batchstuff.api.tumblr.client.SpringTumblrClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;

public class TumblrLoadPostReader implements ItemStreamReader<PersistablePost> {

	private static final int CACHE_SIZE = 20;

	private TumblrBlogService tumblrBlogService;

	private SpringTumblrClient springTumblrClient;

	private AtomicLong idGenerator;

	private List<PersistableBlog> blogs;

	private List<PersistablePost> cached;

	private int currentPostCounter;

	private int currentBlogCounter;

	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {

		idGenerator = new AtomicLong();

		currentPostCounter = 0;

		currentBlogCounter = 0;

		blogs = tumblrBlogService.getAllBlogs();

		cached = new ArrayList<PersistablePost>();

	}

	private PersistablePost createPersistablePostFromPost(Post post) {

		PersistablePost persistablePost = new PersistablePost();

		String url = post.getPostUrl();
		Long timestamp = post.getTimestamp();
		String format = post.getFormat();
		List<String> tags = post.getTags();
		Long tumblrId = post.getId();

		persistablePost.setUrl(url);
		persistablePost.setFormat(format);
		persistablePost.setTimeStamp(timestamp);
		persistablePost.setTags(tags);
		persistablePost.setTumblrId(tumblrId);

		return persistablePost;
	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public PersistablePost read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		PersistablePost persistablePost = null;

		persistablePost = getPost();

		return persistablePost;

	}

	private PersistablePost getPost() {

		PersistablePost res = null;

		if (currentBlogCounter < blogs.size()) {

			if (cached.isEmpty()) {

				PersistableBlog currentBlog = blogs.get(currentBlogCounter);
				Blog blog = springTumblrClient.blogInfo(currentBlog.getName());

				Map<String, String> options = new HashMap<String, String>();
				options.put("limit", createString(CACHE_SIZE));
				options.put("offset", createString(currentPostCounter));

				List<Post> postRead = blog.posts(options);

				if (!postRead.isEmpty()) {

					for (Post post : postRead) {

						PersistablePost transformed = createPersistablePostFromPost(post);
						transformed.setBlogId(currentBlog.getId());
						transformed.setId(getId());
						cached.add(transformed);
					}

					currentPostCounter += CACHE_SIZE;
					return getPost();

				} else {

					currentBlogCounter++;
					currentPostCounter = 0;

					res = getPost();
				}
			} else {

				res = cached.remove(0);
				return res;
			}
		}

		return res;
	}

	private String createString(int i) {

		return "" + i;
	}

	private Long getId() {

		return idGenerator.getAndIncrement();
	}

	public TumblrBlogService getTumblrBlogService() {
		return tumblrBlogService;
	}

	@Autowired
	public void setTumblrBlogService(TumblrBlogService tumblrBlogService) {
		this.tumblrBlogService = tumblrBlogService;
	}

	public SpringTumblrClient getSpringTumblrClient() {
		return springTumblrClient;
	}

	@Autowired
	public void setSpringTumblrClient(SpringTumblrClient springTumblrClient) {
		this.springTumblrClient = springTumblrClient;
	}

}
