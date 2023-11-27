package de.broccolidev.cruddemo;

import de.broccolidev.cruddemo.dao.StudentDAO;
import de.broccolidev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}


	private void deleteAll(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
	}
	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(3);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> larrysonStudents = studentDAO.findByLastName("Larryson");
		for(Student s : larrysonStudents) {
			System.out.println(s.toString());
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student1 = studentDAO.findById(1);
		student1.setFirstName("Scooby");
		studentDAO.update(student1);
	}


	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student s : students) {
			System.out.println(s.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student0 = studentDAO.findById(1);
		System.out.println(student0);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student student1 = new Student("Gary", "Larryson", "Gary@larryson.com");
		Student student2 = new Student("Jerry", "Jerry", "Gary@larryson.com");
		Student student3 = new Student("Mary", "Mary", "Gary@larryson.com");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Larry", "Larryson", "larry@larryson.com");
		studentDAO.save(student);
	}

}
