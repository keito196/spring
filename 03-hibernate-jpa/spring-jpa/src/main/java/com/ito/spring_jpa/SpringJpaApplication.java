package com.ito.spring_jpa;

import com.ito.spring_jpa.dao.StudentDAO;
import com.ito.spring_jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAllStudents();
		System.out.println("Deleted rows: " + numRowsDeleted);
		System.out.println("Done!");
		System.out.println("=====================================");
		System.out.println("Finding all students...");
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		System.out.println("Done!");
		System.out.println("=====================================");
		System.out.println("Deleting all students...");
		numRowsDeleted = studentDAO.deleteAllStudents();
		System.out.println("Deleted rows: " + numRowsDeleted);
		System.out.println("Done!");
		System.out.println("=====================================");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.deleteById(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Finding students with last name: Doe");
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		System.out.println("Done!");
		System.out.println("=====================================");
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student();
		tempStudent.setFirstName("Dat");
		tempStudent.setLastName("Nguyen");
		tempStudent.setEmail("a@gmail.com");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found student: " + myStudent);



	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student();
		tempStudent.setFirstName("John");
		tempStudent.setLastName("Doe");
		tempStudent.setEmail("thanhdat.dut@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
