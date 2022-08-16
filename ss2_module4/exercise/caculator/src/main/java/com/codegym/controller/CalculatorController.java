package com.codegym.controller;

import com.codegym.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculator calculator;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/convert")
    public String result(@RequestParam double number1,
                         @RequestParam double number2,
                         @RequestParam String select, Model model) {

        String result = calculator.result(number1, number2, select);
        model.addAttribute("result", result);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("select", select);

        return "/home";
    }
}
