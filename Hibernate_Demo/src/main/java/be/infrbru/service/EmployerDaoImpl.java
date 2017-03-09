package be.infrbru.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.infrbru.model.Employer;

@Repository
public class EmployerDaoImpl extends AbstractJdbcDao implements EmployerDao {

	private static final String FIND_ALL_EMPLOYERS_QUERY = readSqlFile("/queries/employers_query.sql");
	private static final String FIND_ALL_EMPLOYERBYID_QUERY = readSqlFile("/queries/employerById_query.sql");

	private static final String ID_COLUMN = "ID";
	private static final String WGRNR_COLUMN = "WGR_NR";
	private static final String NAME_COLUMN = "NAAM";

	private static final Logger LOGGER = Logger.getLogger(EmployerDaoImpl.class);

	// SIMPLE DAO IMPLEMENTATION

	public EmployerDaoImpl() {
		System.out.println("MyDAO instantiated");
	}

	// HIBERNATE IMPLEMENTATION
	// INJECTION OF THE SESSION FACTORY
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employer> findByWgrNr(String wgrNr) {
		return sessionFactory.getCurrentSession()
			.createQuery("from Employer emp where emp.wgrNr = ?")
			.setParameter(0, "15215").list();
	}

	// JDBC WAY OF MANIPULATE AND RETRIEVING DATA

	// public List<Employer> findAll() {
	// LOGGER.info("Fetching all Employees from database...");
	// return namedParameterJdbcTemplate.query(FIND_ALL_EMPLOYERS_QUERY, this::mapRow);
	// }
	//
	// public Employer findById(String id) {
	// LOGGER.info("Fetching Employer with from database with id: " + id + " ...");
	// Map<String, String> parameters = new HashMap<>();
	// parameters.put("ID", id);
	//
	// SqlParameterSource sqlParameterSource = new MapSqlParameterSource(parameters);
	//
	// return namedParameterJdbcTemplate.queryForObject(FIND_ALL_EMPLOYERBYID_QUERY, sqlParameterSource, this::mapRow);
	// }
	//
	// private Employer mapRow(ResultSet rs, int count) throws SQLException {
	// Employer employer = new Employer();
	// employer.setId(rs.getString(ID_COLUMN));
	// employer.setWgrNr(rs.getString(WGRNR_COLUMN));
	// employer.setName(rs.getString(NAME_COLUMN));
	// return employer;
	// }

}
