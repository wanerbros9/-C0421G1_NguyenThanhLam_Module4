package com.codegym.dto;

import com.codegym.model.entity.Blog;

import java.util.Set;

public class CategoryDto {
    private int id;
    private String categoryName;
    private Set<Blog> blogSet;

    public CategoryDto() {
    }

    public CategoryDto(String categoryName, Set<Blog> blogSet) {
        this.categoryName = categoryName;
        this.blogSet = blogSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
