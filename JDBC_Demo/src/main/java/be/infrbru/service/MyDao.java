package be.infrbru.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

	private DataSource dataSource;

	public MyDao() {
		System.out.println("MyDAO instantiated");
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<String> selectAll() {
		return null;
	}
}
