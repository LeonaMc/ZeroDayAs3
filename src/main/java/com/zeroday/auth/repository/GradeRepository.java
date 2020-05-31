package com.zeroday.auth.repository;

import com.zeroday.auth.model.Grade;
import com.zeroday.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentID(Long id);

    @Query("SELECT g FROM Grade g WHERE g.module.coordinator=:coordinator")
    List<Grade> findAllByModuleCoordinator(@Param("coordinator") User coordinator);
}

