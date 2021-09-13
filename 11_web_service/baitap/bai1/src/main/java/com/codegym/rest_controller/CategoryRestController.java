package com.codegym.rest_controller;


import com.codegym.dto.CategoryDto;
import com.codegym.model.entity.Category;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category/api")
public class CategoryRestController {
    //    Xem danh sách các category
    //    Xem danh sách các bài viết
    //    Xem danh sách các bài viết của một category
    //    Xem chi tiết một bài viết


    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showList() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.save(category);
        return new ResponseEntity(HttpStatus.OK);
    }
}
