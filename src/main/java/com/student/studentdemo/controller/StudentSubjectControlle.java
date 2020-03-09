package com.student.studentdemo.controller;

import com.student.studentdemo.service.StudentSubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentSubjectControlle {

    private final StudentSubjectService studentSubjectService;

    public StudentSubjectControlle(StudentSubjectService studentSubjectService) {
        this.studentSubjectService = studentSubjectService;
    }

    @GetMapping("/ssbyid/{id}")
    public Object ssbyid(@PathVariable("id") Long id){
        return studentSubjectService.getssbyid(id);
    }

    @GetMapping("/ssbystid/{id}")
    public Object ssbystid(@PathVariable("id") Long id){
        return studentSubjectService.getSsByStId(id);
    }

    @GetMapping("/ssbysbid/{id}")
    public Object ssbysbid(@PathVariable("id") Long id){
        return studentSubjectService.getSsBySbId(id);
    }
}
