package com.zeroday.auth.service;

import com.zeroday.auth.repository.RoleRepository;
import com.zeroday.auth.repository.UserRepository;
import com.zeroday.auth.validator.LoginValidator;
import com.zeroday.auth.model.User;
import com.zeroday.auth.model.WrongAttempt;
import com.zeroday.auth.repository.WrongAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

@Service
public class WrongAttemptServiceImpl implements WrongAttemptService {

    @Autowired
    private WrongAttemptService wrongAttemptService;

    @Autowired
    WrongAttemptRepository wrongAttemptRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${wrong_attempt_concurrent_count}")
    private int wrongAttemptCount;

    @Value("${wrong_attempt_blacklist_count}")
    private int wrongBlackListCount;

    @Override
    public WrongAttempt saveUserWrongAttempt(WrongAttempt wrongAttempt) {
        User user = null;
        if (wrongAttempt.getUserName() != null) {
            user = wrongAttemptService.findByUsername(wrongAttempt.getUserName());
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
    public String loginValidation(String userName, HttpServletRequest request) {
        String result = LoginValidator.VALID;
        int attemptCount = wrongAttemptService.countWrongAttemptByDateAndUserName(userName);
        int attemptBlackListCount = wrongAttemptService.countWrongAttemptByIpAndDateAndUserName(getIpAddress(request), userName);
        if (wrongAttemptCount <= attemptCount) {
            result = "Account locked for today";
        } else if (wrongBlackListCount <= attemptBlackListCount) {
            result = "Your IP has been blacklisted.";
        }else{

        }
        return result;
    }

    @Override
    public String ipValidation(HttpServletRequest request) {
        String result = null;
        int attemptBlackListCount = wrongAttemptService.countWrongAttemptByIpAndDateAndUserName(getIpAddress(request), null);
        if (wrongBlackListCount <= attemptBlackListCount) {
            result = "Your IP has been blacklisted.";
        }else{

        }
        return result;
    }

    @Override
    public int countWrongAttemptByDateAndUserName(String userName) {
        return wrongAttemptRepository.countAllByAttemptDateAndUserNameAndStatus(LocalDate.now(),userName, LoginValidator.WRONG_ATTEMPT);
    }

    @Override
    public int countWrongAttemptByIpAndDateAndUserName(String remoteIpAddress, String userName) {
        return wrongAttemptRepository.countAllByAttemptDateAndStatusAndRemoteIp(LocalDate.now(), LoginValidator.WRONG_ATTEMPT_BLACKLIST,remoteIpAddress);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(User username) {
        userRepository.delete(username);
    }

    protected String getIpAddress(HttpServletRequest request) {
        final String xfHeader = request.getHeader("X-Forward-For");
        if (null == xfHeader) {
            return request.getRemoteAddr();
        } else {
            return xfHeader.split(",")[0];
        }
    }
}
