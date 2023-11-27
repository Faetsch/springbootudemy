package de.broccolidev.cruddemo.dao;

import de.broccolidev.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager em;

    public StudentDAOImpl() {}

    @Autowired
    public StudentDAOImpl(EntityManager em) {this.em = em;}

    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = findById(id);
        em.remove(student);
    }

    @Override
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("FROM Student order by lastName asc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("FROM Student s where lastName=:paramLastName", Student.class);
        query.setParameter("paramLastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberRowsDeleted = em.createQuery("DELETE FROM Student").executeUpdate();
        return numberRowsDeleted;
    }
}
