package it.scompo.batchstuff.api.tumblr.beans;

import java.io.Serializable;
import java.util.List;

public class PersistablePost implements Serializable {

	private static final long serialVersionUID = -4031911555883452141L;

	private Long id;

	private Long blogId;

	private String url;

	private String format;

	private Long timestamp;

	private List<String> tags;

	private Long tumblrId;

	public Long getId() {

		return id;
	}

	public Long getBlogId() {

		return blogId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setTimeStamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public String getFormat() {
		return format;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTumblrId(Long tumblrId) {
		this.tumblrId = tumblrId;
	}

	public Long getTumblrId() {
		return tumblrId;
	}

	@Override
	public String toString() {
		return "PersistablePost [id=" + id + ", blogId=" + blogId + ", url="
				+ url + ", format=" + format + ", timestamp=" + timestamp
				+ ", tags=" + tags + ", tumblrId=" + tumblrId + "]";
	}

}
