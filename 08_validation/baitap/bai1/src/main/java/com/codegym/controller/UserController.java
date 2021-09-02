package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.entity.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"", "/display"})
    public String display(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "display";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated UserDto userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateUser(model);
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);

            userService.save(user);
            redirectAttributes.addFlashAttribute("msg","Success");
            return "redirect:/display";
        }
    }

    private void initCreateUser(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
    }
}
