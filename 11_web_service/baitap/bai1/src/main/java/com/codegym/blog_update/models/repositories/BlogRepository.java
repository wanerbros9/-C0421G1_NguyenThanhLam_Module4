package com.codegym.blog_update.models.repositories;


import com.codegym.blog_update.models.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository < Blog, Integer> {

}
