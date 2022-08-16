package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greeting {
    @GetMapping("/")
    public String greeting() {
        return "/greeting";
    }

@PostMapping("/view")
    public String view(@RequestParam String name , Model model) {
        model.addAttribute("name",name);
        return "/greeting";
    }

}
