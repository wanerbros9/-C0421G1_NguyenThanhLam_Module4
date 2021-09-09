package com.codegym.blog_update.models.service;

import com.codegym.blog_update.models.entities.Category;
import com.codegym.blog_update.models.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceimpl implements CategoryServiceInterface {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List < Category > findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }
}
