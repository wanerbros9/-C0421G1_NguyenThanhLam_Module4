package com.codegym.repository;


import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository < Blog, Integer> {

}
