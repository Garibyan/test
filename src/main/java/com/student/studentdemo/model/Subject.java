package com.student.studentdemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sb_id")
    private Long sbId;
    @Column(name = "name")
    private String name;

    @Column(name = "listOfStSb")
    @OneToMany(mappedBy = "subjectId")
    private List<StudentSubject> listOfStSb;

    public Long getId() {
        return sbId;
    }
    public void setId(Long id) {
        this.sbId = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<StudentSubject> getListOfStSb() {
        return listOfStSb;
    }
    public void setListOfStSb(List<StudentSubject> listOfStSb) {
        this.listOfStSb = listOfStSb;
    }
}
