package com.ito.spring_jpa.dao;

import com.ito.spring_jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    // Constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);
        query.setParameter("lastName", lastName);
        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        Student student = entityManager.find(Student.class, theStudent.getId());
        if (student != null) {
            student.setFirstName(theStudent.getFirstName());
            student.setLastName(theStudent.getLastName());
            student.setEmail(theStudent.getEmail());
            entityManager.merge(student);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        if (theStudent != null) {
            entityManager.remove(theStudent);
        }
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        int numberOfDeletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numberOfDeletedRows;
    }
}
