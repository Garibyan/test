package com.student.studentdemo.controller;

import com.student.studentdemo.dto.StudentDTO;
import com.student.studentdemo.model.Student;
import com.student.studentdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/students")
//    public List<Student> getAllStudents() {
//        List<Student> listOfStudents = studentService.getAllUsers();
//
//        return listOfStudents;
//    }

    @GetMapping(path = "/students", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<StudentDTO>> query(@RequestParam(value = "search") String query) {
        List<StudentDTO> result = null;
        try {
            result= studentService.searchByQuery(query);
        }catch (IllegalArgumentException iae){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(result);
        }
        return  ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/getstudentbyid/{id}")
    public StudentDTO getStudentById(@PathVariable("id") Long id){

        return studentService.getStudent(id);
    }

    @GetMapping("/byid/{id}")
    public Student getById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }
}