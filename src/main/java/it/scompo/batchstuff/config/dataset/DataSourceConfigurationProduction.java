package it.scompo.batchstuff.config.dataset;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@Profile(value = { "!test", "prod" })
public class DataSourceConfigurationProduction {

	@Bean
	public DataSource productionDatabase() {

		BasicDataSource basicDataSource = createDatasource();
		DatabasePopulatorUtils.execute(createBatchTables(), basicDataSource);
		return basicDataSource;
	}

	private DatabasePopulator createBatchTables() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("org/springframework/batch/core/schema-drop-derby.sql"));
		databasePopulator.addScript(new ClassPathResource("org/springframework/batch/core/schema-derby.sql"));
		return databasePopulator;
	}

	private BasicDataSource createDatasource() {

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource
				.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		basicDataSource
				.setUrl("jdbc:derby://localhost:1527/tumblrDb;create=true");
		return basicDataSource;
	}

}
