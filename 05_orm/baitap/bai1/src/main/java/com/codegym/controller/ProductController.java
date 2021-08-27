package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String create(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable int id, Model model, @ModelAttribute Product product) {
        product = productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(Product product) {
        productService.update(product);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable int id, Model model, @ModelAttribute Product product) {
        product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product);
        redirectAttributes.addFlashAttribute("msg", "Success");
        return "redirect:/index";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model, @ModelAttribute Product product) {
        productService.findById(id);
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("product", productService.findByName(name));
        return "/view";
    }
}
