package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String home(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {

        String keywordVal = keyword.orElse("");

        Page<Product> products = this.productService.findAllByNameContaining(keywordVal, pageable);

        model.addAttribute("product", products);

        model.addAttribute("keywordVal", keywordVal);

        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        this.productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product) {
        this.productService.save(product);
        return "redirect:/";
    }

}
