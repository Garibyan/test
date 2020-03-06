package com.student.studentdemo.service;

import com.student.studentdemo.dto.SubjectDTO;
import com.student.studentdemo.model.Subject;
import com.student.studentdemo.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public SubjectService(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }

    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjectList = subjectRepository.findAll();
        Type listType = new TypeToken<List<SubjectDTO>>() {}.getType();
        List<SubjectDTO> result = modelMapper.map(subjectList, listType);
        return result;
    }

    public List<?> getSubjectsByStudentId(Long id){
        return subjectRepository.getSubjectsByStudentId(id);
    }
}



