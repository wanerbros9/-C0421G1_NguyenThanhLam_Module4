package com.codegym.blog_update.controllers;

import com.codegym.blog_update.models.entities.Category;
import com.codegym.blog_update.models.service.BlogServiceInterface;
import com.codegym.blog_update.models.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/home-category")
public class CategoryController {
    @Autowired
    CategoryServiceInterface categoryService;
    @Autowired
    BlogServiceInterface blogServiceInterface;

    @GetMapping(value = "/view")
    public String showCategory (Model model){
        model.addAttribute("categoryList",this.categoryService.findAll());
        model.addAttribute("blogList",blogServiceInterface.showList());
        return "category-view/view";
    }

    @GetMapping(value = "/create")
    public String showCreate (Model model){
        model.addAttribute("category",new Category());
        return "category-view/create";
    }

    @PostMapping(value = "/create")
    public String create (@ModelAttribute Category category, Model model, RedirectAttributes redirectAttributes){
        this.categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg","create category success!");
        return "redirect:/home-category/view";
    }

}
