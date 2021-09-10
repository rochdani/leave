package com.example.leavemanagement.service;

import com.example.leavemanagement.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
