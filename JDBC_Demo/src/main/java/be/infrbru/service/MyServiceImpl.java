package be.infrbru.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import be.infrbru.model.Employer;

@Service
public class MyServiceImpl implements MyService {

	private static final Logger LOGGER = Logger.getLogger(MyServiceImpl.class);

	private EmployerDao employerDao;

	// AUTOWIRED WILL INJECT THE MYDAO IN THE CONSTRUCTOR WHEN THE SERVICE IS CREATED BY SPRING
	@Autowired
	public MyServiceImpl(EmployerDao employerDao) {
		this.employerDao = employerDao;
		LOGGER.info("MyService instantiated");
	}

	@Override
	public List<Employer> selectAllEmployers() {
		return employerDao.findAll();
	}

	@Override
	public Employer selectEmployerById(String id) {
		Assert.notNull(id, "id must not be null");
		return employerDao.findById(id);
	}

}
