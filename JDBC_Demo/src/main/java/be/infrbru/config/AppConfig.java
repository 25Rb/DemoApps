package be.infrbru.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "be.infrbru.service", "be.infrbru.dao" })
public class AppConfig {

	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private String databaseUrl = "jdbc:oracle:thin:@PVMDEV:1521:PVMDEV";
	private String databaseUsername = "ikmo2001";
	private String databasePassword = "oerbier";

	private static final Logger LOGGER = Logger.getLogger(AppConfig.class);

	@Bean
	public DataSource myDataSource() {
		BasicDataSource source = new BasicDataSource();

		// SET SOURCE PARAMETERS TO CONNECT TO DB
		source.setDriverClassName(driverClassName);
		source.setUrl(databaseUrl);
		source.setUsername(databaseUsername);
		source.setPassword(databasePassword);

		LOGGER.info("MyDataSource is created for user: " + databaseUsername);

		return source;
	}
}
