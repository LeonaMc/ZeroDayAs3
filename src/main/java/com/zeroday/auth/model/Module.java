package com.zeroday.auth.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @Column(name = "module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String module_name;

    private String school;

    @ManyToOne
    private User coordinator;

    private String module_topic;

    @Column(name = "closed", nullable = false)
    private boolean closed = false;

    @ManyToMany
    private Set<User> users;

    @Transient
    private int numberOfRegistredStudents;

    public Module() {
        super();
    }

    public Module(Long id, String module_name, String school, String module_topic,
                  Boolean enroll) {
        super();
        this.id = id;
        this.module_name = module_name;
        this.school = school;
        this.module_topic = module_topic;

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

    public User getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(User coordinator) {
        this.coordinator = coordinator;
    }

    public String getModule_topic() {
        return module_topic;
    }

    public void setModule_topic(String module_topic) {
        this.module_topic = module_topic;
    }


    public int getNumberOfRegistredStudents() {
        return numberOfRegistredStudents;
    }

    public void setNumberOfRegistredStudents(int numberOfRegistredStudents) {
        this.numberOfRegistredStudents = numberOfRegistredStudents;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}