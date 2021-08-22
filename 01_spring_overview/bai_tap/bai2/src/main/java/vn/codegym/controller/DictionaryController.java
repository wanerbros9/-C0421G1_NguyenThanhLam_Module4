package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.service.IDictionaryService;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionary;

    @GetMapping(value = "/dictionary")
    public String display() {
        return "dictionary";
    }

    @RequestMapping(value = "/dictionary")
    public String result(@RequestParam String word, Model model) {
        model.addAttribute("result",dictionary.findWord(word));
        return "dictionary";
    }
}
