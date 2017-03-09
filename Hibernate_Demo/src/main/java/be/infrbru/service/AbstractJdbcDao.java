package be.infrbru.service;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractJdbcDao {

	private static final Logger LOGGER = Logger.getLogger(AbstractJdbcDao.class);

	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		LOGGER.info("Injecting dataSource");
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	protected static final String readSqlFile(String filename) {
		try {
			return IOUtils.toString(AbstractJdbcDao.class.getResourceAsStream(filename), "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
