package com.student.studentdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom_name")
    private List<Student> studentsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Classroom() {
    }

    public Classroom(Long id, String name, List<Student> studentsList) {
        this.id = id;
        this.name = name;
        this.studentsList = studentsList;
    }
}
