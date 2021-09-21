package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.service.customer.ICustomerService;
import com.codegym.model.service.customer.ICustomerTypeService;
import com.codegym.model.service.impl.customer.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping({"", "/list"})
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateCustomer(model);
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("msg", "Create success");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("customerDto", this.customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated CustomerDto customerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateCustomer(model);
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("msg", "Edit success");
            return "redirect:/customer/list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id,
                         RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete success");
        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String list(Model model,
                           @PageableDefault(value = 5) Pageable pageable,
                           @RequestParam (value = "name") String name) {
        Page<Customer> customers = customerService.findCustomerByCustomerName(name,pageable);
        model.addAttribute("customers", customers);
        return "/customer/list";
    }

    private void initCreateCustomer(Model model) {
        model.addAttribute("customerTypes", customerTypeService.findAll());
    }

}
