package com.codegym.controller;

import com.codegym.model.bean.Health;
import com.codegym.model.service.HealthService;
import com.codegym.model.service.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HealthController {

    @Autowired
    HealthService healthService;

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("health", new Health());
        List<String> symptomList = new ArrayList<>();
        symptomList.add("Fever");
        symptomList.add("Cough");
        symptomList.add("Difficulty of breathing");
        symptomList.add("Sore throat");
        symptomList.add("Vomiting");
        symptomList.add("Diarrhea");
        symptomList.add("Skin haemorrhage");
        symptomList.add("Rash");
        model.addAttribute("symptomList", symptomList);
        List<String> exposureList = new ArrayList<>();
        exposureList.add("\n" +
                "Yes\tNo\n" +
                "Visit any poultry farm / living animal market / slaughter house / contact to animal");
        exposureList.add("Care for a sick person of communicable diseases");
        model.addAttribute("exposureList", exposureList);
        return "create";
    }

    @PostMapping("/create")
    public String createHealth(@ModelAttribute("health") Health health,
                               RedirectAttributes redirectAttributes) {
        healthService.save(health);
        redirectAttributes.addFlashAttribute("msg", "Success");
        return "redirect:/display";
    }
}
