package com.student.studentdemo.controller;

import com.student.studentdemo.dto.SubjectDTO;
import com.student.studentdemo.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public List<SubjectDTO> getAllSubjects() {
        List<SubjectDTO> listOfSubjects = subjectService.getAllSubjects();

        return listOfSubjects;
    }
}
