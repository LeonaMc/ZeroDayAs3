package com.zeroday.auth.service;

import com.zeroday.auth.validator.LoginValidator;
import com.zeroday.auth.model.User;
import com.zeroday.auth.repository.RoleRepository;
import com.zeroday.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private WrongAttemptService wrongAttemptService;

    @Value("${wrong_attempt_concurrent_count}")
    private int wrongAttemptCount;

    @Value("${wrong_attempt_blacklist_count}")
    private int wrongBlackListCount;

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


    @Override
    public String loginValidation(String userName, HttpServletRequest request) {
        String result = LoginValidator.VALID;
        int attemptCount = wrongAttemptService.countWrongAttemptByDateAndUserName(userName);
        if (wrongAttemptCount <= attemptCount) {
            result = "Account lock for today";
        } else {
            int attemptBlackListCount = wrongAttemptService.countWrongAttemptByIpAndDateAndUserName(getIpAddress(request), userName);
            if (wrongBlackListCount <= attemptBlackListCount) {
                result = "Your IP has been blacklisted.";
            }
        }
        return result;
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
