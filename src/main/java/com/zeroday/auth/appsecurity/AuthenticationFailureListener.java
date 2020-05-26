package com.zeroday.auth.appsecurity;

import com.zeroday.auth.model.WrongAttempt;
import com.zeroday.auth.service.WrongAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    WrongAttemptService wrongAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        Authentication authentication = event.getAuthentication();
        final String xfHeader = request.getHeader("X-Forward-For");
        WrongAttempt wrongAttempt = new WrongAttempt();
        if (null == xfHeader) {
            wrongAttempt.setRemoteIp(request.getRemoteAddr());
        } else {
            wrongAttempt.setRemoteIp(xfHeader.split(",")[0]);
        }
        if (authentication != null) {
            wrongAttempt.setUserName(authentication.getName());
        }
        WrongAttempt attempt = wrongAttemptService.saveUserWrongAttempt(wrongAttempt);
        request.setAttribute("error", "ghgfhghffgh ");
        System.out.println("Bad Credentials:: " + attempt);
    }
}
