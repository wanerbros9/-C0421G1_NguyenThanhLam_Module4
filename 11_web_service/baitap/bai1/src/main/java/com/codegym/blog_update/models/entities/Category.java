package com.codegym.blog_update.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(String name, Set < Blog > blogs) {
        this.name = name;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set < Blog > getBlogs() {
        return blogs;
    }

    public void setBlogs(Set < Blog > blogs) {
        this.blogs = blogs;
    }
}
