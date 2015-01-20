package it.scompo.batchstuff.api.tumblr.client;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/tumblr.properties")
public class TumblrConfigurationFactoryBean implements
		FactoryBean<TumblrConfigurationData> {

	private static TumblrConfigurationData tumblrConfiguration;

	@Autowired
	private Environment environment;

	@Override
	public TumblrConfigurationData getObject() throws Exception {

		if (tumblrConfiguration == null) {

			tumblrConfiguration = new TumblrConfigurationData();

			tumblrConfiguration.setConsumerKey(environment
					.getProperty("tumblr.oauth.consumerKey"));
			tumblrConfiguration.setConsumerSecret(environment
					.getProperty("tumblr.oauth.consumerSecret"));
			tumblrConfiguration.setToken(environment
					.getProperty("tumblr.oauth.token"));
			tumblrConfiguration.setTokenSecret(environment
					.getProperty("tumblr.oauth.token.secret"));
		}

		return tumblrConfiguration;
	}

	@Override
	public Class<?> getObjectType() {

		return TumblrConfigurationData.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
