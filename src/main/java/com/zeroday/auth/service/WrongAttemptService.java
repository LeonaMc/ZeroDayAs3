package com.zeroday.auth.service;

import com.zeroday.auth.model.WrongAttempt;
import java.time.LocalDate;

public class WrongAttemptService {

    WrongAttempt saveUserWrongAttempt(WrongAttempt wrongAttempt);

    int countWrongAttemptByDateAndUserName(String userName);

    int countWrongAttemptByIpAndDateAndUserName(String remoteIpAddress, String userName);
}
