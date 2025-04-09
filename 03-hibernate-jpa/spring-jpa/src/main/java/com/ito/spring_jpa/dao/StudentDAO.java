package com.ito.spring_jpa.dao;

import com.ito.spring_jpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void deleteById(Integer id);

    int deleteAllStudents();
}
