package com.student.studentdemo.repository;

import com.student.studentdemo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

//    @Query(value = "SELECT SUBJECT.NAME AS NAME FROM SUBJECT WHERE ID  IN" +
//            "(SELECT STUDENT_SUBJECT.SUBJECT_ID AS SID FROM STUDENT_SUBJECT WHERE STUDENT_ID  = :id)", nativeQuery = true)
//    List<?> getSubjectsByStudentId(@Param("id") Long id);

    List<Subject> getSubjectsByListOfStSbIn(List<?> listOfStSb);
}