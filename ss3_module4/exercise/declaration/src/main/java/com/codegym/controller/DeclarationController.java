package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService declarationService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("birth",declarationService.yearOfBirth());
        model.addAttribute("gender",declarationService.gender());
        model.addAttribute("nationality",declarationService.nationality());
        return "/homes";
    }
}
