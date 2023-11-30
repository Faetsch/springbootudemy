package de.broccolidev.cruddemo.dao;

import de.broccolidev.cruddemo.entity.Course;
import de.broccolidev.cruddemo.entity.Instructor;
import de.broccolidev.cruddemo.entity.InstructorDetail;
import de.broccolidev.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Long id) {
        Instructor instructorById = entityManager.find(Instructor.class, id);

        List<Course> courses = instructorById.getCourses();

        for(Course c : courses) {
            c.setInstructor(null);
        }

        entityManager.remove(instructorById);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Long id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(Long id) {
        InstructorDetail instructorDetailById = findInstructorDetailById(id);

        //remove the associated object reference
        instructorDetailById.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetailById);
    }

    @Override
    public List<Course> findCoursesByInstructorId(Long id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Long id) {
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsById(Long id) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(Long id) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.students where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(Long id) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :data", Student.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
