package com.student.studentdemo.repository;

import com.student.studentdemo.model.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

    Object findByStudentId(Long studentId);
}
