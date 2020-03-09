package com.student.studentdemo.repository;

import com.student.studentdemo.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

    List<Object> findByStudentId(Long studentId);
    List<Object> findBySubjectId(Long subjectid);
}
