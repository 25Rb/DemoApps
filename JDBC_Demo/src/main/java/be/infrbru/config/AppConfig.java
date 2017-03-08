package be.infrbru.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "be.infrbru.service", "be.infrbru.dao" })
public class AppConfig {

	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private String databaseUrl = "jdbc:oracle:thin:@PVMDEV:1521:PVMDEV";
	private String databaseUsername = "inforbru";
	private String databasePassword = "EersteDag1";

	@Bean
	public DataSource myDataSource() {
		BasicDataSource source = new BasicDataSource();

		// SET SOURCE PARAMETERS TO CONNECT TO DB
		source.setDriverClassName(driverClassName);
		source.setUrl(databaseUrl);
		source.setUsername(databaseUsername);
		source.setPassword(databasePassword);

		System.out.println("MyDataSource is created for user: " + databaseUsername);

		return source;
	}
}
