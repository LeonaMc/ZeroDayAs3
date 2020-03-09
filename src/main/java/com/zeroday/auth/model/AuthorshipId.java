package com.zeroday.auth.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthorshipId implements Serializable {

    Long id_module;

    Long id_author;

    public AuthorshipId(){}

    public AuthorshipId( Long id_module, Long id_author){
        this.id_author = id_author;
        this.id_module = id_module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorshipId authorshipId = (AuthorshipId) o;
        return id_module.equals(authorshipId.id_module) &&
                id_author.equals(authorshipId.id_author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_module, id_author);
    }

    public Long getId_Author(){
        return id_author;
    }
    public Long getId_Module(){
        return id_module;
    }
}
