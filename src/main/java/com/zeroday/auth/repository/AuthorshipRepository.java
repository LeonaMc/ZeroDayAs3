package com.zeroday.auth.repository;

import com.zeroday.auth.exception.AuthorNotFoundException;
import com.zeroday.auth.model.Authorship;
import com.zeroday.auth.model.Author;
import com.zeroday.auth.model.AuthorshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorshipRepository extends JpaRepository<Authorship, AuthorshipId> {

    @Query("select a.id_author from Authorship a where a.id_module = ?1")
    List<Long> findAuthorByModuleId(Long module_id) throws AuthorNotFoundException;


}




