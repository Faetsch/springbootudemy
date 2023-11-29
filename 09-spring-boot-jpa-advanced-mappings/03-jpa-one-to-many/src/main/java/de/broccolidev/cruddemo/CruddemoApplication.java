package de.broccolidev.cruddemo;

import de.broccolidev.cruddemo.dao.AppDAO;
import de.broccolidev.cruddemo.entity.Course;
import de.broccolidev.cruddemo.entity.Instructor;
import de.broccolidev.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

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
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		long id = 10L;
		appDAO.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		long id = 10L;

		Course courseById = appDAO.findCourseById(id);
		courseById.setTitle("Advanced Gaming");
		appDAO.update(courseById);
		System.out.println(courseById);
	}

	private void updateInstructor(AppDAO appDAO) {
		long id = 1L;
		Instructor instructorById = appDAO.findInstructorById(id);

		instructorById.setEmail("yip@yap.com");
		appDAO.update(instructorById);
		System.out.println(instructorById);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		long id = 1;
		Instructor instructorByIdJoinFetch = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructorByIdJoinFetch);
		System.out.println("Courses: " + instructorByIdJoinFetch.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		long instructorId = 1L;
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Instructor: " + instructor);

		List<Course> coursesByInstructorId = appDAO.findCoursesByInstructorId(instructorId);
		instructor.setCourses(coursesByInstructorId);

		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1L);
		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Bort", "Bors", "bort@bors.com");

		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/bortbors", "working");

		Course course1 = new Course();
		course1.setTitle("Gaming");

		Course course2 = new Course();
		course2.setTitle("Guitar");

		instructor.add(course1);
		instructor.add(course2);

		instructor.setInstructorDetail(instructorDetail);
		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(3L);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetailById = appDAO.findInstructorDetailById(2L);
		System.out.println("Instructor Detail: " + instructorDetailById);
		System.out.println("Instructor: " + instructorDetailById.getInstructor());
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
