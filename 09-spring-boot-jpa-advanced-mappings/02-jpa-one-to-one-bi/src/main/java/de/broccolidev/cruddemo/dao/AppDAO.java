package de.broccolidev.cruddemo.dao;

import de.broccolidev.cruddemo.entity.Instructor;
import de.broccolidev.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(Long id);

    void deleteInstructorById(Long id);

    InstructorDetail findInstructorDetailById(Long id);

    void deleteInstructorDetailById(Long id);
}
