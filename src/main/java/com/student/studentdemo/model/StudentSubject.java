package com.student.studentdemo.model;

import javax.persistence.*;

@Entity
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ss_id")
    private Long ssId;

    @JoinColumn(name = "student_id", referencedColumnName = "st_id")
    private Long studentId;

    @JoinColumn(name = "subject_id", referencedColumnName = "sb_id")
    private Long subjectId;

    public Long getSsId() {
        return ssId;
    }
    public void setSsId(Long ssId) {
        this.ssId = ssId;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
