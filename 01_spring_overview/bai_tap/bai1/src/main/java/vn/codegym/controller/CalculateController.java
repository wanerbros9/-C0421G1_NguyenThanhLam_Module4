package vn.codegym.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculateController {

    @GetMapping(value = "/calculate")
    public String showAll(){
        return "calculate";
    }

    @RequestMapping(value = "/calculate")
    public String getCalc(HttpServletRequest request, Model model){
//        int vnd = Integer.parseInt(request.getParameter("vnd"));
        int usd = Integer.parseInt(request.getParameter("usd"));
        model.addAttribute("usdCurrency",usd*23000);
        return "calculate";
    }
}
