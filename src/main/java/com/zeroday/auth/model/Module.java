package com.zeroday.auth.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String module_name;

    private String school;

    public Module(){
        super();
    }
    public Module(Long id, String module_name,  String school) {
        super();
        this.id = id;
        this.module_name = module_name;
        this.school=school;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getModule_name() {
        return module_name;
    }
    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
}