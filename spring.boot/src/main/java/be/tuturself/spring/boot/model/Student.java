package be.tuturself.spring.boot.model;

import org.joda.time.DateTime;

import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.Person.Sex;

public class Student {

	private Integer studentId;
	private Address address;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Sex sex;
	private String telephoneNumber;
	private DateTime dateOfBirth;
	private Integer age;
	private String companyEmail;
	private String nationalIdentityCardNumber;
	private String nationalIdentificationNumber;

	public Student(int studentId, Person p) {
		this.studentId = studentId;
		this.nationalIdentityCardNumber = p.getNationalIdentificationNumber();
		this.address = p.getAddress();
		this.firstName = p.getFirstName();
		this.middleName = p.getMiddleName();
		this.lastName = p.getLastName();
		this.email = p.getEmail();
		this.sex = p.getSex();
		this.telephoneNumber = p.getTelephoneNumber();
		this.dateOfBirth = p.getDateOfBirth();
		this.age = p.getAge();
		this.nationalIdentificationNumber = p.getNationalIdentificationNumber();
		this.companyEmail = p.getCompanyEmail();
	}

	public Student(Integer studentId, String firstName, String lastName, String email) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public Address getAddress() {
		return address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Sex getSex() {
		return sex;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public String getNationalIdentityCardNumber() {
		return nationalIdentityCardNumber;
	}

	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}
}