package com.codegym.rest_controller;


import com.codegym.dto.BlogDto;
import com.codegym.model.entity.Blog;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/blog/api")
public class BlogRestController {
//    Xem danh sách các category
//    Xem danh sách các bài viết
//    Xem danh sách các bài viết của một category
//    Xem chi tiết một bài viết

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> showAll() {
        List<Blog> blogs = blogService.showAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBlog(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlog(@RequestParam String category) {
        List<Blog> blogs = blogService.findByCategory(category);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
