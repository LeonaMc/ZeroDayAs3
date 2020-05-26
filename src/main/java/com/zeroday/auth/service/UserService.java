package com.zeroday.auth.service;

import com.zeroday.auth.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    void delete(User username);

    String loginValidation(String userName, HttpServletRequest request);

}
