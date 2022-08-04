package io.pragra.learning.jdbcfirstapp.rest;

import io.pragra.learning.jdbcfirstapp.entity.Student;
import io.pragra.learning.jdbcfirstapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class StudentApi {
    private StudentService service;

    public StudentApi(StudentService service) {
        this.service = service;
    }

    @PostMapping("/student")
    public int createStudent(@RequestBody Student student) {
        return this.service.createStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAll(){
        return this.service.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getAll(@PathVariable int id){
        System.out.println(id);
        return this.service.getOneById(id);
    }
}
