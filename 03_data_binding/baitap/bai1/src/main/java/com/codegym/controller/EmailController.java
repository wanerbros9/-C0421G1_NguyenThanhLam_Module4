package com.codegym.controller;

import com.codegym.model.bean.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @GetMapping("/edit")
    public String showEmail(Model model){
        model.addAttribute("edit", new Email());
        return "edit";
    }

    @PostMapping("/edit")
    public String editEmail(@ModelAttribute("edit")Email email,Model model){
        model.addAttribute("email",email);
        return "home";
    }
}
