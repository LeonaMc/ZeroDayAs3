package com.zeroday.auth.repository;

import com.zeroday.auth.model.payFees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeesRepository extends JpaRepository<payFees, Long> {
}
