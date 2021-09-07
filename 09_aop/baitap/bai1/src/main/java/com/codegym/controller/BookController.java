package com.codegym.controller;

import com.codegym.model.entity.Book;
import com.codegym.model.entity.RentCode;
import com.codegym.model.service.impl.BookService;
import com.codegym.model.service.impl.RentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RentCodeService rentCodeService;

    @GetMapping({"", "/display"})
    public String display(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "display";
    }

    @GetMapping("detail/{id}")
    public String viewDetail(@PathVariable int id, Model model) throws Exception {
        Book book = bookService.findById(id);
        if (book.getAmount() == 0){
            throw new Exception();
        }
        model.addAttribute("book", this.bookService.findById(id));
        return "detail";
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setAmount(book.getAmount() - 1);
        Long code = Math.round(Math.random() * 89999 + 10000);
        RentCode rentCode = new RentCode(code, book);
        bookService.save(book);
        rentCodeService.save(rentCode);
        redirectAttributes.addFlashAttribute("msg", "Book Rented, " + "your rent code is " + code);
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }
//    @PostMapping("/pay")
//    public String payBook(){
//
//    }

}
