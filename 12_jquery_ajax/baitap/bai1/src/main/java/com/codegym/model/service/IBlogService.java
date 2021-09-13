package com.codegym.model.service;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    List<Blog> showAll();

    List<Blog> findByCategory(String category);
}
