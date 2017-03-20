package be.tuturself.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import service.StudentService;

/**
 * @author infrbru
 */
@SpringBootApplication
public class StudentSearchApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudentSearchApplication.class, args);
	}

	@Bean
	public StudentService studentService() {
		return new StudentService();
	}
}
