package be.tuturself.spring.boot.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.tuturself.spring.boot.model.Student;
import be.tuturself.spring.boot.service.StudentRepository;
import be.tuturself.spring.boot.service.StudentService;

@RestController
@EnableAutoConfiguration
public class StudentAPI {

	private static Map<Integer, Student> studentDB;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/students")
	public List<Student> searchStudent() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@RequestMapping("/students")
	public Student searchStudent(@RequestParam(name = "studentId", required = true) Integer studentId) {
		Student student = studentService.getStudentById(studentId);
		return student;
	}
}