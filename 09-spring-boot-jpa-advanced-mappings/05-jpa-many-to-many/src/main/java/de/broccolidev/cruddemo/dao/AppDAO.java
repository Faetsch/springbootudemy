package de.broccolidev.cruddemo.dao;

import de.broccolidev.cruddemo.entity.Course;
import de.broccolidev.cruddemo.entity.Instructor;
import de.broccolidev.cruddemo.entity.InstructorDetail;
import de.broccolidev.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(Long id);

    void deleteInstructorById(Long id);

    InstructorDetail findInstructorDetailById(Long id);

    void deleteInstructorDetailById(Long id);

    List<Course> findCoursesByInstructorId(Long id);

    Instructor findInstructorByIdJoinFetch(Long id);

    void update(Instructor instructor);

    Course findCourseById(Long id);

    void update(Course course);

    void deleteCourseById(Long id);

    void save(Course course);

    Course findCourseAndReviewsById(Long id);

    Course findCourseAndStudentsByCourseId(Long id);

    Student findStudentAndCoursesByStudentId(Long id);

    void update(Student student);

    void deleteStudentById(Long id );
}
