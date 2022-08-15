package com.springmvc.controller;

import com.springmvc.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringMVC {

    @Autowired
    private IMoneyService moneyService;

    @GetMapping("/")
    public String spring() {
        return "/spring";
    }

    @PostMapping("/result")
    public String result(@RequestParam double money, Model model) {
        double result = moneyService.money(money);
        model.addAttribute("result", result);
        return "/spring";
    }
}
