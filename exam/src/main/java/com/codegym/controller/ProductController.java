package com.codegym.controller;

import com.codegym.dto.OrderDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.entity.Order;
import com.codegym.model.entity.Product;
import com.codegym.model.entity.ProductType;
import com.codegym.model.service.IOrderService;
import com.codegym.model.service.IProductService;
import com.codegym.model.service.IProductTypeService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("productDto", this.productService.findById((long) id));
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("productTypes", productService.findAll());
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated ProductDto productDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasFieldErrors()) {
            initEditOrder(model);
            return "/edit";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("msg", "Edit Success");
            return "redirect:/list";
        }
    }

    private void initEditOrder(Model model) {
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("productTypes", productTypes);

        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
    }
}
