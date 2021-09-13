package com.codegym.model.repository;

import com.codegym.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByCategory_CategoryName(String category);
}
