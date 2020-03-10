package com.zeroday.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private String module_coord;

    private String module_topic;

    private boolean enroll;

    public Module() {
        super();
    }

    public Module(Long id, String module_name, String school, String module_coord, String module_topic,
                  Boolean enroll) {
        super();
        this.id = id;
        this.module_name = module_name;
        this.school = school;
        this.module_coord = module_coord;
        this.module_topic = module_topic;
        this.enroll = enroll;
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

    public String getModule_coord() {
        return module_coord;
    }

    public void setModule_coord(String module_coord) {
        this.module_coord = module_coord;
    }

    public String getModule_topic() {
        return module_topic;
    }

    public void setModule_topic(String module_topic) {
        this.module_topic = module_topic;
    }

    public boolean isEnroll() {
        return enroll;
    }

    public void setEnroll(boolean enroll) {
        this.enroll = enroll;
    }

}