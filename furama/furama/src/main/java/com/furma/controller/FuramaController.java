package com.furma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {

    @GetMapping("/")
    public String home(){
        return "layout/home";
    }

    @GetMapping("/about")
    public String about(){
        return "redirect:/#about";
    }

     @GetMapping("/facility")
    public String facility(){
        return "redirect:/#facility";
     }
}
