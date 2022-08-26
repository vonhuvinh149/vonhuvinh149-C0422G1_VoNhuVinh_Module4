package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String borrow(@RequestParam int idBook, RedirectAttributes redirectAttributes) throws Exception {
        Book book = bookService.findById(idBook);
        if (book.getAmountBook() > 0) {
            book.setAmountBook(book.getAmountBook() - 1);
            book.setBorrowAll(book.getBorrowAll() + 1);
        }else {
            throw new Exception();
        }
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg","mượn thành công");
        return "redirect:/";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam int idBook,RedirectAttributes redirectAttributes) throws Exception {
        Book book = bookService.findById(idBook);
        if (book.getAmountBook() < book.getTotalBook()) {
            book.setAmountBook(book.getAmountBook() + 1);
        }else {
            throw new Exception();
        }
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg","trả thành công");
        return "redirect:/";
    }

    @ExceptionHandler(value = Exception.class)
    public String errors() {
        return "/errors";
    }
}
