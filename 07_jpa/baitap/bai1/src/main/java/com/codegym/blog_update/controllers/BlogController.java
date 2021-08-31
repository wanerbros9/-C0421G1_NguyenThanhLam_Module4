package com.codegym.blog_update.controllers;


import com.codegym.blog_update.models.entities.Blog;
import com.codegym.blog_update.models.service.BlogServiceInterface;
import com.codegym.blog_update.models.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class BlogController {
    @Autowired
    BlogServiceInterface blogService;
    @Autowired
    CategoryServiceInterface categoryServiceInterface;

    @GetMapping(value = "/view")
    public String show(Model model) {
        List<Blog> blogList = blogService.showList();
        model.addAttribute("blogList", blogList);
        return "blog-view/view";
    }
    @GetMapping (value = "/create")
    public String showCreate (Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",categoryServiceInterface.findAll());
        return "blog-view/create";
    }

    @PostMapping (value = "/create")
    public String create (@ModelAttribute Blog newBlog, Model model, RedirectAttributes redirectAttributes){
        this.blogService.save(newBlog);
        redirectAttributes.addFlashAttribute("msg","Create new blog success!!");
        return "redirect:/home/view";
    }
    @GetMapping (value = "/update/{id}")
    public String showUpdate (@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "blog-view/edit";
    }

    @PostMapping (value = "/update")
    public String update (@ModelAttribute Blog newBlog,Model model, RedirectAttributes redirectAttributes){
        this.blogService.save(newBlog);
        redirectAttributes.addFlashAttribute("msg","update success!!");
        return "redirect:/home/view";
    }

    @GetMapping (value = "/delete/{id}")
    public String showDelete (@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "blog-view/delete";
    }
    @PostMapping (value = "/delete")
    public String delete (@ModelAttribute Blog blog,Model model,RedirectAttributes redirectAttributes){
        this.blogService.delete(blog);
        redirectAttributes.addFlashAttribute("msg","delete success!!");
        return "redirect:/home/view";
    }

    @GetMapping (value = "detail/{id}")
    public String viewDetail (@PathVariable int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "blog-view/detail";
    }
}
