package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String home(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blog", blogs);
        return "/list_blog";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog) {
        this.blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Blog blog = this.blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/detail";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int remove){
        this.blogService.deleteById(remove);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", this.blogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        this.blogService.save(blog);
        return "redirect:/";
    }

}
