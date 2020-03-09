package com.student.studentdemo.repository;

import com.student.studentdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentByStId (Long id);
    List<Student> getStudentsByListOfStSbIn(List<?> listOfStSb);
}
