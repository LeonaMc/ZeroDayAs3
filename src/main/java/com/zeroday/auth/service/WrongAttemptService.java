package com.zeroday.auth.service;

import com.zeroday.auth.model.User;
import com.zeroday.auth.model.WrongAttempt;

import javax.servlet.http.HttpServletRequest;


public interface WrongAttemptService {

    WrongAttempt saveUserWrongAttempt(WrongAttempt wrongAttempt);

    int countWrongAttemptByDateAndUserName(String userName);

    int countWrongAttemptByIpAndDateAndUserName(String remoteIpAddress, String userName);

    String ipValidation(HttpServletRequest request);

    void save(User user);

    User findByUsername(String username);

    void delete(User username);

    String loginValidation(String userName, HttpServletRequest request);

    User getCurrentUser();

}
