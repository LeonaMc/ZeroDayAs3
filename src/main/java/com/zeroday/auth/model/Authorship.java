package com.zeroday.auth.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "authorship")
@IdClass(AuthorshipId.class)
@NamedQuery(name = "Authorship.findByEmailAddress",
        query = "select a.id_author from Authorship a where a.id_module = ?1")
public class Authorship {
    @Id
    @NotBlank
    private Long id_module;

    @Id
    @NotBlank
    private Long id_author;


    public Authorship(){
        super();
    }
    public Authorship(Long id_module, Long id_author) {
        super();
        this.id_module = id_module;
        this.id_author = id_author;
    }

    public Long getId_module() {
        return id_module;
    }
    public void setId_module(Long id_module) {
        this.id_module = id_module;
    }

    public Long getId_author() {
        return id_author;
    }
    public void setId_author(Long id_author) {
        this.id_author = id_author;
    }



}
