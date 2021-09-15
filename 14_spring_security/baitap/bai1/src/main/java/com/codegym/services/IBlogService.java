package com.codegym.services;


import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
     public List<Blog> showList();
     public void save( Blog blog);
     public Blog  findById (int id);
     public void delete(Blog blog);
}
