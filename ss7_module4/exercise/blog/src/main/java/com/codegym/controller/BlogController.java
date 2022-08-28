package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String home(Model model, @PageableDefault(size = 2) Pageable pageable,
                                    @RequestParam Optional<String> keyword) {

        String keywordVal = keyword.orElse("");
        Page<Blog> blogList = this.blogService.findByTitleContaining(keywordVal, pageable);
        model.addAttribute("blogs", blogList);
        model.addAttribute("keywordVal", keywordVal);

        return "/list_blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {

        Blog blog = this.blogService.findById(id);
        model.addAttribute("blogs", blog);

        return "/detail";
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("blog", new Blog());
        List<Category> categoryList = this.categoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "/create";
    }

    @PostMapping("/create")

    public String save(@ModelAttribute Blog blog) {
        this.blogService.save(blog);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        model.addAttribute("blog", this.blogService.findById(id));
        List<Category> categoryList = this.categoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {

        this.blogService.save(blog);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {

        this.blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("msg","xoá thành công");

        return "redirect:/";
    }
}
