package com.codegym.controller;

import com.codegym.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @GetMapping("/shopping_cart")
    public ModelAndView listCart(@SessionAttribute Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
