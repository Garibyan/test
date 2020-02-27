package com.student.studentdemo.controller;


import com.student.studentdemo.model.Classroom;
import com.student.studentdemo.model.Student;
import com.student.studentdemo.repository.ClassroomRepository;
import com.student.studentdemo.service.ClassroomService;
import com.student.studentdemo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final ClassroomService classroomService;

    public StudentController(StudentService studentService, ClassroomService classroomService) {
        this.studentService = studentService;
        this.classroomService = classroomService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> listOfStudents = studentService.getAllUsers();

        return listOfStudents;
    }


    @GetMapping("/classrooms")
    public List<Classroom> getAllClassrooms() {
        List<Classroom> listOfClassrooms = classroomService.getAllUsers();

        return listOfClassrooms;
    }
}
