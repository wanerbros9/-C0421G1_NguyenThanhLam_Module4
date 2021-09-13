package com.codegym.model.service;

import com.codegym.model.entity.Blog;
import com.codegym.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> showAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategory(String category) {
        return blogRepository.findAllByCategory_CategoryName(category);
    }
}
