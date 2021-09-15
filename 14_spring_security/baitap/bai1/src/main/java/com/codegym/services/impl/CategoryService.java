package com.codegym.services.impl;

import com.codegym.model.Category;
import com.codegym.repository.CategoryRepository;
import com.codegym.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List <Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }
}
