package com.codegym.controllers;

import com.codegym.model.Category;
import com.codegym.services.IBlogService;
import com.codegym.services.ICategoryService;
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
    private ICategoryService categoryService;
    @Autowired
    private IBlogService IBlogService;

    @GetMapping(value = "/view")
    public String showCategory (Model model){
        model.addAttribute("categoryList",this.categoryService.findAll());
        model.addAttribute("blogList", IBlogService.showList());
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
