package com.codegym.blog_update.rest_controller;


import com.codegym.blog_update.models.entities.Category;
import com.codegym.blog_update.models.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("category/api")
public class CategoryRestController {

    @Autowired
    private CategoryServiceInterface categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> showList(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
}
