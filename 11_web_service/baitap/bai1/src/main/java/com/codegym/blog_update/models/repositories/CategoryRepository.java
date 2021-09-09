package com.codegym.blog_update.models.repositories;

import com.codegym.blog_update.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository< Category, Integer > {
}
