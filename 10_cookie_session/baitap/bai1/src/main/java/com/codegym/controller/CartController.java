package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.entity.Product;
import com.codegym.model.service.impl.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto){
        return new ModelAndView("cart/list","cartDto",cartDto);
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
            return "redirect:/cart";
        }
    }

    @PostMapping("/checkout")
    public String checkOut(@SessionAttribute("cart") CartDto cartDto,
                           RedirectAttributes redirectAttributes){
        cartDto.getProductMap().clear();
        redirectAttributes.addFlashAttribute("msg", "Check out success");
        return "redirect:/shop";
    }
}
