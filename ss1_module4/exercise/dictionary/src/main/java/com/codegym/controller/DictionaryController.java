package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String home() {
        return "/dictionary";
    }

    @PostMapping("/view")
    public String view(@RequestParam String word, Model model) {
        String result = this.dictionaryService.english(word);
        if (result == null) {
            model.addAttribute("result", "không tìm thấy");
        } else {
            model.addAttribute("result", result);
        }
        return "/dictionary";
    }
}
