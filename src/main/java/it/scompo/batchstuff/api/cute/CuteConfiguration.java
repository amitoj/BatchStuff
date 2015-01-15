package it.scompo.batchstuff.api.cute;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CuteConfiguration {
	
	@Bean(name = "sqlUtils")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public SqlUtils sqlUtils() {

		SqlUtils sqlUtils = new SqlUtils();

		return sqlUtils;
	}

}
