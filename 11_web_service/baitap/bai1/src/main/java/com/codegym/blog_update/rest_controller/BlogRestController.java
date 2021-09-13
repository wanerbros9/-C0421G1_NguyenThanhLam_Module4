package com.codegym.blog_update.rest_controller;

import com.codegym.blog_update.models.entities.Blog;
import com.codegym.blog_update.models.service.BlogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("blog/api")
public class BlogRestController {

    @Autowired
    private BlogServiceInterface blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> blogList = blogService.showList();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
