package com.codegym.services.impl;



import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> showList() {
        return this.blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void delete(Blog blog) {
        this.blogRepository.delete(blog);
    }
}
