package it.scompo.batchstuff.config.dataset;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile(value={"test","!prod"})
public class DataSourceConfigurationEmbedded {

	@Bean
	public DataSource embeddedDatabase() {

		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.DERBY)
				.setName("APP")
				.continueOnError(true)
				.addScript(
						"classpath:org/springframework/batch/core/schema-drop-derby.sql")
				.addScript(
						"classpath:org/springframework/batch/core/schema-derby.sql")
				.build();
	}
	
}
