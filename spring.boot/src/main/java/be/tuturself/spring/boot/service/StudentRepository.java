package be.tuturself.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import be.tuturself.spring.boot.model.Student;

/**
 * @author infrbru
 */

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public StudentRepository() {

	}

	public List<Student> findAll() {
		List<Student> result = jdbcTemplate.query("SELECT studentId, firstName,lastName, email FROM student",
			(rs, rowNum) -> new Student(rs.getInt("studentId"), rs.getString("firstName"), rs.getString("lastName"),
				rs.getString("email")));
		return result;
	}
}
