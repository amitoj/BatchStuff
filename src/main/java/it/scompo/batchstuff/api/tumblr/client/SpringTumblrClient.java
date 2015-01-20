package it.scompo.batchstuff.api.tumblr.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.request.RequestBuilder;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.User;

@Component(value = "springTumblrClient")
public class SpringTumblrClient extends JumblrClient {

	@Autowired
	private TumblrConfigurationData tumblrConfigurationData;

	private JumblrClient jumblrClient;
	
	@PostConstruct
	public void init(){
		
		jumblrClient = new JumblrClient(tumblrConfigurationData.getConsumerKey(),
				tumblrConfigurationData.getConsumerSecret(),
				tumblrConfigurationData.getToken(),
				tumblrConfigurationData.getTokenSecret());
	}

	public SpringTumblrClient() {

	}

	@Override
	public void setToken(String token, String tokenSecret) {

		jumblrClient.setToken(token, tokenSecret);
	}

	@Override
	public User user() {

		return jumblrClient.user();
	}

	@Override
	public List<Post> userDashboard(Map<String, ?> options) {

		return jumblrClient.userDashboard(options);
	}

	@Override
	public List<Post> userDashboard() {

		return jumblrClient.userDashboard();
	}

	@Override
	public List<Blog> userFollowing(Map<String, ?> options) {

		return jumblrClient.userFollowing(options);
	}

	@Override
	public List<Blog> userFollowing() {

		return jumblrClient.userFollowing();
	}

	@Override
	public List<Post> tagged(String tag, Map<String, ?> options) {

		return jumblrClient.tagged(tag, options);
	}

	@Override
	public List<Post> tagged(String tag) {

		return jumblrClient.tagged(tag);
	}

	@Override
	public Blog blogInfo(String blogName) {

		return jumblrClient.blogInfo(blogName);
	}

	@Override
	public List<User> blogFollowers(String blogName, Map<String, ?> options) {

		return jumblrClient.blogFollowers(blogName, options);
	}

	@Override
	public List<User> blogFollowers(String blogName) {

		return jumblrClient.blogFollowers(blogName);
	}

	@Override
	public List<Post> blogLikes(String blogName, Map<String, ?> options) {

		return jumblrClient.blogLikes(blogName, options);
	}

	@Override
	public List<Post> blogLikes(String blogName) {

		return jumblrClient.blogLikes(blogName);
	}

	@Override
	public List<Post> blogPosts(String blogName, Map<String, ?> options) {

		return jumblrClient.blogPosts(blogName, options);
	}

	@Override
	public List<Post> blogPosts(String blogName) {

		return jumblrClient.blogPosts(blogName);
	}

	@Override
	public Post blogPost(String blogName, Long postId) {

		return jumblrClient.blogPost(blogName, postId);
	}

	@Override
	public List<Post> blogQueuedPosts(String blogName, Map<String, ?> options) {

		return jumblrClient.blogQueuedPosts(blogName, options);
	}

	@Override
	public List<Post> blogQueuedPosts(String blogName) {

		return jumblrClient.blogQueuedPosts(blogName);
	}

	@Override
	public List<Post> blogDraftPosts(String blogName, Map<String, ?> options) {

		return jumblrClient.blogDraftPosts(blogName, options);
	}

	@Override
	public List<Post> blogDraftPosts(String blogName) {

		return jumblrClient.blogDraftPosts(blogName);
	}

	@Override
	public List<Post> blogSubmissions(String blogName, Map<String, ?> options) {

		return jumblrClient.blogSubmissions(blogName, options);
	}

	@Override
	public List<Post> blogSubmissions(String blogName) {

		return jumblrClient.blogSubmissions(blogName);
	}

	@Override
	public List<Post> userLikes(Map<String, ?> options) {

		return jumblrClient.userLikes(options);
	}

	@Override
	public List<Post> userLikes() {

		return jumblrClient.userLikes();
	}

	@Override
	public String blogAvatar(String blogName, Integer size) {

		return jumblrClient.blogAvatar(blogName, size);
	}

	@Override
	public String blogAvatar(String blogName) {

		return jumblrClient.blogAvatar(blogName);
	}

	@Override
	public void like(Long postId, String reblogKey) {

		jumblrClient.like(postId, reblogKey);
	}

	@Override
	public void unlike(Long postId, String reblogKey) {

		jumblrClient.unlike(postId, reblogKey);
	}

	@Override
	public void follow(String blogName) {

		jumblrClient.follow(blogName);
	}

	@Override
	public void unfollow(String blogName) {

		jumblrClient.unfollow(blogName);
	}

	@Override
	public void postDelete(String blogName, Long postId) {

		jumblrClient.postDelete(blogName, postId);
	}

	@Override
	public Post postReblog(String blogName, Long postId, String reblogKey,
			Map<String, ?> options) {

		return jumblrClient.postReblog(blogName, postId, reblogKey, options);
	}

	@Override
	public Post postReblog(String blogName, Long postId, String reblogKey) {

		return jumblrClient.postReblog(blogName, postId, reblogKey);
	}

	@Override
	public void postEdit(String blogName, Long id, Map<String, ?> detail)
			throws IOException {

		jumblrClient.postEdit(blogName, id, detail);
	}

	@Override
	public Long postCreate(String blogName, Map<String, ?> detail)
			throws IOException {

		return jumblrClient.postCreate(blogName, detail);
	}

	@Override
	public <T extends Post> T newPost(String blogName, Class<T> klass)
			throws IllegalAccessException, InstantiationException {

		return jumblrClient.newPost(blogName, klass);
	}

	@Override
	public void setRequestBuilder(RequestBuilder builder) {

		jumblrClient.setRequestBuilder(builder);
	}

}
