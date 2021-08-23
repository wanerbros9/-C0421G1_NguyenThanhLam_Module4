package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, ModelMap modelMap) {
        modelMap.addAttribute("condiment", Arrays.toString(condiment));
        return "index";
    }

    @RequestMapping("/")
    public String display() {
        return "index";
    }
}
