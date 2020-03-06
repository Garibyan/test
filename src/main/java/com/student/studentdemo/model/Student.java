package com.student.studentdemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "st_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "listOfStSb")
    @OneToMany(mappedBy = "studentId")
    private List<StudentSubject> listOfStSb;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public List<StudentSubject> getListOfStSb() {
        return listOfStSb;
    }
    public void setListOfStSb(List<StudentSubject> listOfStSb) {
        this.listOfStSb = listOfStSb;
    }
}

