package com.student.studentdemo.service;

import com.student.studentdemo.repository.StudentSubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectService {

    private final StudentSubjectRepository studentSubjectRepository;


    public StudentSubjectService(StudentSubjectRepository studentSubjectRepository) {
        this.studentSubjectRepository = studentSubjectRepository;
    }

    public Object getssbystid(Long id){
        return studentSubjectRepository.findByStudentId(id);
    }


}
