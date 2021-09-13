package com.codegym.model.service;

import com.codegym.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void delete(int id);

    Category findById(int id);
}
