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
    @NotBlank
    private String module;
    private Long grade;
    public Grade(){
        super();
    }
    public Grade(Long studentID, String studentName,  String module, Long grade) {
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

    public String getModule() { return module; }
    public void setModule(String module) { this.module = module; }

    public Long getGrade() { return grade; }
    public void setGrade(Long grade) { this.grade = grade; }
}