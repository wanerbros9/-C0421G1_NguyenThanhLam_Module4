package com.codegym.blog_update.models.service;


import com.codegym.blog_update.models.entities.Blog;

import java.util.List;

public interface BlogServiceInterface {
     public List<Blog> showList();
     public void save( Blog blog);
     public Blog  findById (int id);
     public void delete(Blog blog);
}
