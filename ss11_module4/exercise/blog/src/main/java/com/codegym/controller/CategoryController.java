package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService ;

    @GetMapping("list_category")
     public String listCategory(Model model){
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("category",categories);
         return "/list_category";
     }
}
