package com.codegym.controller;

import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService sandwich;

    @GetMapping("/")
    public String home(Model model) {
        List<String> stringList = this.sandwich.findAll();
        model.addAttribute("stringList", stringList);
        return "/home";
    }

    @PostMapping("/covert")
    public String success(@RequestParam(required = false) List<String> condiments, Model model) {
        List<String> stringList = this.sandwich.findAll();
        model.addAttribute("stringList", stringList);
        if (condiments != null) {
            model.addAttribute("condiments", condiments);
        }else {
            model.addAttribute("condiments", "you haven't chosen any condiments");
        }
        return "/home";
    }

}
