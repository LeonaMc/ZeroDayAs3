package com.zeroday.auth.service;

import com.zeroday.auth.validator.LoginValidator;
import com.zeroday.auth.model.User;
import com.zeroday.auth.model.WrongAttempt;
import com.zeroday.auth.repository.WrongAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class WrongAttemptServiceImpl implements WrongAttemptService {

    @Autowired
    private UserService userService;

    @Autowired
    WrongAttemptRepository wrongAttemptRepository;

    @Override
    public WrongAttempt saveUserWrongAttempt(WrongAttempt wrongAttempt) {
        User user = null;
        if (wrongAttempt.getUserName() != null) {
            user = userService.findByUsername(wrongAttempt.getUserName());
        }
        if (null == user) {
            wrongAttempt.setAttemptMessage("Invalid User Found");
            wrongAttempt.setStatus("BlackList");
        } else {
            wrongAttempt.setUser(user);
            wrongAttempt.setAttemptMessage("Bad Credentials");
            wrongAttempt.setStatus("WrongAttempt");
        }
        wrongAttempt.setAttemptDate(LocalDate.now());
        wrongAttempt.setAttemptDateTime(LocalDateTime.now());
        return wrongAttemptRepository.save(wrongAttempt);
    }

    @Override
    public int countWrongAttemptByDateAndUserName(String userName) {
        return wrongAttemptRepository.countAllByAttemptDateAndUserNameAndStatus(LocalDate.now(),userName, LoginValidator.WRONG_ATTEMPT);
    }

    @Override
    public int countWrongAttemptByIpAndDateAndUserName(String remoteIpAddress, String userName) {
        return wrongAttemptRepository.countAllByAttemptDateAndUserNameAndStatusAndRemoteIp(LocalDate.now(),userName, LoginValidator.WRONG_ATTEMPT_BLACKLIST,remoteIpAddress);
    }
}
