package com.student.studentdemo.service;

import com.github.tennaito.rsql.jpa.JpaCriteriaCountQueryVisitor;
import com.github.tennaito.rsql.jpa.JpaCriteriaQueryVisitor;
import com.student.studentdemo.dto.StudentDTO;
import com.student.studentdemo.dto.SubjectDTO;
import com.student.studentdemo.model.Student;
import com.student.studentdemo.repository.StudentRepository;
import com.student.studentdemo.repository.StudentSubjectRepository;
import com.student.studentdemo.repository.SubjectRepository;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentSubjectRepository studentSubjectRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;
    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository,
                          StudentSubjectRepository studentSubjectRepository,
                          SubjectRepository subjectRepository,
                          SubjectService subjectService,
                          EntityManager entityManager,
                          ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.studentSubjectRepository = studentSubjectRepository;
        this.subjectRepository = subjectRepository;
        this.subjectService = subjectService;
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    public List<StudentDTO> searchByQuery(String queryString) {
        RSQLVisitor<CriteriaQuery<Student>, EntityManager> visitor = new JpaCriteriaQueryVisitor<>();
        CriteriaQuery<Student> query;
        query = getCriteriaQuery(queryString, visitor);
        List<Student> studentsList = entityManager.createQuery(query).getResultList();
        Type listType = new TypeToken<List<StudentDTO>>() {}.getType();
        List<StudentDTO> resultList = modelMapper.map(studentsList, listType);
        if (resultList == null || resultList.isEmpty()) {
            return Collections.emptyList();
        }
        return resultList;
    }

    public Long countByQuery(String queryString) {
        RSQLVisitor<CriteriaQuery<Long>, EntityManager> visitor = new JpaCriteriaCountQueryVisitor<Student>();
        CriteriaQuery<Long> query;
        query = getCriteriaQuery(queryString, visitor);

        return entityManager.createQuery(query).getSingleResult();
    }

    private <T> CriteriaQuery<T> getCriteriaQuery(String queryString, RSQLVisitor<CriteriaQuery<T>, EntityManager> visitor) {
        Node rootNode;
        CriteriaQuery<T> query;
        try {
            rootNode = new RSQLParser().parse(queryString);
            query = rootNode.accept(visitor, entityManager);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return query;
    }

    public StudentDTO getStudent(Long id) {
        Student student = studentRepository.getStudentByStId(id);
        StudentDTO studentDto = modelMapper.map(student, StudentDTO.class);
        List<SubjectDTO> subjects = subjectService.getSubjectsBySsList(id);
        return studentDto;
    }

    public List<StudentDTO> getStudentsBySubject(String name){
        List<?>listOfStSb = studentSubjectRepository.findBySubjectId(subjectRepository.getSubjectByName(name).getId());
        List<Student> studentsBySubject = studentRepository.getStudentsByListOfStSbIn(listOfStSb);
        Type listType = new TypeToken<List<StudentDTO>>() {}.getType();
        return modelMapper.map(studentsBySubject, listType);
    }

    public List<Object> getStudentAndSubject(Long id) {
        Student student = studentRepository.getStudentByStId(id);
        StudentDTO studentDto = modelMapper.map(student, StudentDTO.class);
        List<SubjectDTO> subjects = subjectService.getSubjectsBySsList(id);
        List<Object> objectList = new ArrayList<>();
        objectList.add(studentDto);
        objectList.add(subjects);
        return objectList;
    }
}