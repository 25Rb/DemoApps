package be.infrbru.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "be.infrbru.service", "be.infrbru.dao" })
@EnableTransactionManagement
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

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("be.infrbru.model");
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
