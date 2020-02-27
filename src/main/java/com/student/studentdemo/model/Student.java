package com.student.studentdemo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom_name;

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

    public Classroom getClassroom() {
        return classroom_name;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom_name = classroom;
    }

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Classroom classroom_name) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classroom_name = classroom_name;
    }
}

