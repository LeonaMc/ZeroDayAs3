package com.zeroday.auth.repository;

import com.zeroday.auth.model.WrongAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WrongAttemptRepository extends JpaRepository<WrongAttempt,Long> {

    int countAllByAttemptDateAndUserNameAndStatus(LocalDate localDate, String userName, String status);

    int countAllByAttemptDateAndUserNameAndStatusAndRemoteIp(LocalDate localDate,String userName,String Status, String remoteAddress);
}

