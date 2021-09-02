package com.codegym.model.service;

import com.codegym.model.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();

    public void save(User user);
}
