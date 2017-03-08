package be.infrbru.service;

import java.util.List;

import be.infrbru.model.Employer;

public interface MyService {

	List<Employer> selectAllEmployers();

	Employer selectEmployerById(String id);

}
