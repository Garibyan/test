package com.student.studentdemo.service;

import com.student.studentdemo.repository.StudentSubjectRepository;
import com.student.studentdemo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSubjectService {

    private final StudentSubjectRepository studentSubjectRepository;
    private final SubjectRepository subjectRepository;

    public StudentSubjectService(StudentSubjectRepository studentSubjectRepository, SubjectRepository subjectRepository) {
        this.studentSubjectRepository = studentSubjectRepository;
        this.subjectRepository = subjectRepository;
    }

    public Object getssbyid(Long id){
        return studentSubjectRepository.findById(id);
    }

    public List<?> getSsByStId(Long id){
        return studentSubjectRepository.findByStudentId(id);
    }

    public Object getSsBySbId(Long id){
        return studentSubjectRepository.findBySubjectId(id);
    }
}
