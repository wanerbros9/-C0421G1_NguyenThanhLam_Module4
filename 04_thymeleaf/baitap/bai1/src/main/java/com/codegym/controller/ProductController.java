package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String create(Product product){
        product.setId((int) (Math.random()*10000));
        productService.save(product);
        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable int id, Model model,@ModelAttribute Product product){
        product = productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(Product product){
        productService.update(product);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id,Model model,@ModelAttribute Product product){
        product = productService.findById(id);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("msg","Success");
        return "redirect:/index";
    }
}
