package api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Student;
import service.StudentService;

@RestController
@EnableAutoConfiguration
public class StudentAPI {

	private static Map<Integer, Student> studentDB;

	@Autowired
	private StudentService studentService;

	@RequestMapping("/students")
	public Student searchStudent(@RequestParam(name = "studentId", required = true) Integer studentId) {
		Student student = studentService.getStudentById(studentId);
		return student;
	}
}