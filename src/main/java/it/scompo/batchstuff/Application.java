package it.scompo.batchstuff;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
	}

}
