package com.zeroday.auth.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    private Long studentID;
    @NotBlank
    private String studentName;

    @ManyToOne
    private Module module;
    private Long grade;

    public Grade(){
        super();
    }
    public Grade(Long studentID, String studentName,  Module module, Long grade) {
        super();
        this.studentID = studentID;
        this.studentName = studentName;
        this.module = module;
        this.grade = grade;
    }

    public Long getStudentID() { return studentID; }
    public void setStudentID(Long studentID) { this.studentID = studentID; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }

    public Long getGrade() { return grade; }
    public void setGrade(Long grade) { this.grade = grade; }
}