package com.codegym.dto;

import com.codegym.model.entity.Category;

public class BlogDto {
    private int id;
    private String title;
    private String content;
    private String signature;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(String title, String content, String signature, Category category) {
        this.title = title;
        this.content = content;
        this.signature = signature;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
