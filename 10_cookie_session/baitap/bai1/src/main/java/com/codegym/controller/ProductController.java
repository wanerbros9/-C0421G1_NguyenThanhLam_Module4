package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.entity.Product;
import com.codegym.model.service.impl.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public CartDto initCard() {
        return new CartDto();
    }


    @GetMapping({""})
    public String showProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "display";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Add Success");
        return "redirect:/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        } else {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.addProduct(productDto);
            return "redirect:/shop";
        }
    }

    @GetMapping("/decrease/{id}")
    public String decreaseCart(@PathVariable Long id,
                               @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        } else {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.decreaseProduct(productDto);
            return "redirect:/cart";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.removeProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id).get());
        return "detail";
    }
}
