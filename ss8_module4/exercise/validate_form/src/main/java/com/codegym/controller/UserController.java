package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String display(@RequestParam Optional<String> email, @PageableDefault(size = 3) Pageable pageable,
                          Model model) {
        String emailUser = email.orElse("");
        Page<User> users = this.userService.findByEmailContaining(emailUser, pageable);
        model.addAttribute("email", email);
        model.addAttribute("user", users);
        return "/list_user";
    }

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("user", new UserDto());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("user") @Valid UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        new UserDto().validate(userDto, bindingResult);
        User user = new User();
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        BeanUtils.copyProperties(userDto, user);

        this.userService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");

        return "redirect:/";
    }
}
