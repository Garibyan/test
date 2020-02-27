package com.student.studentdemo.service;

import com.student.studentdemo.model.Student;
import com.student.studentdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllUsers() {
        List<Student> result = (List<Student>) studentRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Student>();
        }
    }


}
