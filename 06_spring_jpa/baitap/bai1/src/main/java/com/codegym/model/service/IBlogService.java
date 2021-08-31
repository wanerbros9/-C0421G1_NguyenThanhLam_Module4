package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.IBlogRepository;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void remove(int id);

    Blog findById(int id);
}
