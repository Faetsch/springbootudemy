package de.broccolidev.cruddemo.dao;

import de.broccolidev.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student findById(Integer id);
    void save(Student student);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
