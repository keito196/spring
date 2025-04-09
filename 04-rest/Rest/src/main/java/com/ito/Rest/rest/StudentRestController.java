package com.ito.Rest.rest;

import com.ito.Rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = List.of(
                new Student("John", "Doe"),
                new Student("Jane", "Smith"),
                new Student("Jim", "Brown")
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        if (id < 0 || id >= students.size()) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }
        return students.get(id);
    }

}
