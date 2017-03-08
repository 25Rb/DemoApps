package be.infrbru.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	private static final Logger LOGGER = Logger.getLogger(MyService.class);

	private MyDao myDao;

	// AUTOWIRED WILL INJECT THE MYDAO IN THE CONSTRUCTOR WHEN THE SERVICE IS CREATED BY SPRING
	@Autowired
	public MyService(MyDao myDao) {
		this.myDao = myDao;
		LOGGER.info("MyService instantiated");
	}

	public void doStuff() {
		LOGGER.info("MyService is working hard on the DAO: " + myDao.getClass().getName());
	}

}
