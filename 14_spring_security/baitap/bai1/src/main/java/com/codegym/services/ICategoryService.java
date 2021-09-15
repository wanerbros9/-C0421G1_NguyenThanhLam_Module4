package com.codegym.services;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
    public void save (Category category);
}
