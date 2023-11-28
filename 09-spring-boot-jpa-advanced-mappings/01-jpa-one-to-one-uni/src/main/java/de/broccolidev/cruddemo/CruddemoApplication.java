package de.broccolidev.cruddemo;

import de.broccolidev.cruddemo.dao.AppDAO;
import de.broccolidev.cruddemo.entity.Instructor;
import de.broccolidev.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteInstructorById(1L);
	}

	private void findInstructor(AppDAO appDAO) {
		Instructor existingInstructor = appDAO.findInstructorById(2L);
		System.out.println("Instructor: " + existingInstructor);
		System.out.println("Instructor Details: " + existingInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Chad", "Darby", "chad@darby.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/chaddarby", "gaming");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving Instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");

	}

}
