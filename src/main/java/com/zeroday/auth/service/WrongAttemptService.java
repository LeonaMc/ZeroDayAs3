package com.zeroday.auth.service;

import com.zeroday.auth.model.WrongAttempt;


public interface WrongAttemptService {

    WrongAttempt saveUserWrongAttempt(WrongAttempt wrongAttempt);

    int countWrongAttemptByDateAndUserName(String userName);

    int countWrongAttemptByIpAndDateAndUserName(String remoteIpAddress, String userName);
}
