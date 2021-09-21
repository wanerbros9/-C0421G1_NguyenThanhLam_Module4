package com.codegym.services;

import com.codegym.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
//    void save(User user);
//    void update(User user);
    User findById(int id);
}
