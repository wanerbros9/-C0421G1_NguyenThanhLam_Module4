package controller;

import model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private Calculator calculator;

    @GetMapping("/calculate")
    public String Calculate(@RequestParam("leftOperand") double leftOperand,
                            @RequestParam("operator") String operator,
                            @RequestParam("rightOperand") double rightOperand,
                            Model model) {
        String result = "";
        try {
            result = String.valueOf(calculator.calculate(leftOperand, operator, rightOperand));
        } catch (Exception e) {
            result = e.getMessage();
        }
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/")
    public String display() {
        return "index";
    }
}
