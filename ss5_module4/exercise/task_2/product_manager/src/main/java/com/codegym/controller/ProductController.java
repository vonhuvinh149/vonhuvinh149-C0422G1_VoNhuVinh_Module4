package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> productList = this.productService.findAll();
        model.addAttribute("product", productList);
        return "/home";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute  Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam int id  ,Model model){
        model.addAttribute("product" , productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute Product product){
        productService.update(product.getId(),product);
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam int id, RedirectAttributes redirectAttributes){
    productService.remove(id);
    redirectAttributes.addAttribute("massage","xoá thành công");
        return "redirect:/";
    }
}
