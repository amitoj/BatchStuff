package it.scompo.batchstuff;

import it.scompo.batchstuff.api.tumblr.client.TumblrConfigurationFactoryBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

	@Autowired
	private TumblrConfigurationFactoryBean tumblrConfigurationFactoryBean;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
