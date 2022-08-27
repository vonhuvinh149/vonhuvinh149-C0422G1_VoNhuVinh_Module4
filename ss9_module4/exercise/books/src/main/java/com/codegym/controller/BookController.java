package com.codegym.controller;

import com.codegym.common.NotFoundBook;
import com.codegym.common.NotMaxBook;
import com.codegym.model.Book;
import com.codegym.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    public String listBook(Model model, @PageableDefault(size = 2) Pageable pageable,
                           @RequestParam Optional<String> keyword){

        String keywordVal = keyword.orElse("");
        Page<Book> books = this.bookService.findByBookNameContaining(keywordVal,pageable);
        model.addAttribute("book", books );
        model.addAttribute("keyword",keywordVal);

        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Book book = this.bookService.findById(id);
        model.addAttribute("book", book);
        return "/detail";
    }

    @GetMapping("/backBook/{id}")
    public String backBook(@PathVariable int id, Model model) {
        Book book = this.bookService.findById(id);
        model.addAttribute("book", book);
        return "/pay";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam int idBook, RedirectAttributes redirectAttributes) throws NotFoundBook, Exception, NotMaxBook {
        Book book = bookService.findById(idBook);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg","mượn thành công");

        return "redirect:/";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam int idBook,RedirectAttributes redirectAttributes) throws NotMaxBook, Exception, NotFoundBook {

        Book book = bookService.findById(idBook);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg","trả thành công");

        return "redirect:/";
    }

    @ExceptionHandler(value = NotFoundBook.class)
    public String errors() {
        return "/error";
    }

    @ExceptionHandler(value = NotMaxBook.class)
    public String errorsTotal() {
        return "/errors";
    }
}
