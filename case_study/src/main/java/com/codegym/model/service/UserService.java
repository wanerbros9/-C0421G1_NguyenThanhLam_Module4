package com.codegym.model.service;


import com.codegym.model.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
//    void save(User user);
//    void update(User user);
    User findById(int id);
}
