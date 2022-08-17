package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ConfigurationController {

    @Autowired
    private IConfigurationService configurationService;

    @GetMapping("/")
    public String homes() {
        return "/home";
    }

    @GetMapping("/setting")
    public String settings(Model model) {
        model.addAttribute("email", new Email());
        List<String> languages = configurationService.languages();
        List<Integer> pageSize = configurationService.pageSize();
        model.addAttribute("language", languages);
        model.addAttribute("pageSize", pageSize);
        return "/settings";
    }

    @PostMapping("/saves")
    public String save(@ModelAttribute Email email, Model model) {
        model.addAttribute("email", email);
        return "/save";
    }
}
