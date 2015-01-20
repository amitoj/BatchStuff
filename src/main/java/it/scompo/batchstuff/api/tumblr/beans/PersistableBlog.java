package it.scompo.batchstuff.api.tumblr.beans;

import java.io.Serializable;

import com.tumblr.jumblr.types.Blog;

public class PersistableBlog implements Serializable {

	private static final long serialVersionUID = 8592499955028858068L;

	private Long id;

	private String url;

	private String name;

	private String description;

	private String title;

	private String avatar;

	public PersistableBlog() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void addFields(Blog blog) {

		title = blog.getTitle();
		name = blog.getName();
		description = blog.getDescription();
		avatar = blog.avatar();
	}

	@Override
	public String toString() {
		return "PersistableBlog [id=" + id + ", url=" + url + ", name=" + name
				+ ", description=" + description + ", title=" + title
				+ ", avatar=" + avatar + "]";
	}

}
