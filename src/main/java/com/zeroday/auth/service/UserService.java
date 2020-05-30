package com.zeroday.auth.service;

import com.zeroday.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User getCurrentUser();

    void delete(User username);
}
