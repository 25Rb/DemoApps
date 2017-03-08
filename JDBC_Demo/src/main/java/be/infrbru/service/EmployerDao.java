package be.infrbru.service;

import java.util.List;

import be.infrbru.model.Employer;

public interface EmployerDao {

	List<Employer> findAll();

	Employer findById(String id);

}
