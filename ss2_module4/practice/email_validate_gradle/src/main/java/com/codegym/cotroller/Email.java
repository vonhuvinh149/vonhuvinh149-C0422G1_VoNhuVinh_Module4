package com.codegym.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class Email {


    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public Email() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/validate")
    public String user(@RequestParam String email, ModelMap model) {
        boolean isValidate = this.validate(email);
        if (!isValidate) {
            model.addAttribute("message", "email is valid");
            return "/home";
        }
        model.addAttribute("email", email);
        return "/success";
    }

    private boolean validate(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
