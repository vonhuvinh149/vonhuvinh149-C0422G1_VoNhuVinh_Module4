package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String home(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 1000));
        productService.create(product);
        return "redirect:/product/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    public String remove(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addAttribute("message", "xoa thanh cong");
        return "redirect:/product/";
    }

    @GetMapping("/search")
    public String searchProductByName(@RequestParam String name, Model model) {
        List<Product> products = this.productService.searchProductByName(name);
        model.addAttribute("product", products);
        return "/home";
    }
}
