package com.zeroday.auth.repository;

import com.zeroday.auth.model.Grade;
import com.zeroday.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentID(Long id);
}

