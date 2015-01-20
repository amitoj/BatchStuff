package it.scompo.batchstuff.api.tumblr.client;


public class TumblrConfigurationData{

	private String consumerKey;

	private String consumerSecret;

	private String token;

	private String tokenSecret;

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	@Override
	public String toString() {
		return "TumblrConfiguration [consumerKey=" + consumerKey
				+ ", consumerSecret=" + consumerSecret + ", token=" + token
				+ ", tokenSecret=" + tokenSecret + "]";
	}

}
