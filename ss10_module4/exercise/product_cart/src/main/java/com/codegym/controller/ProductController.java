package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String listProduct(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/add")
    public String createCart(@RequestParam String action, @PathVariable Integer id, @SessionAttribute Cart cart) {

        Optional<Product> product = this.productService.findById(id);

        if (!product.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "reidrect:/shopping_cart";
        }
        return "/cart";
    }
}
