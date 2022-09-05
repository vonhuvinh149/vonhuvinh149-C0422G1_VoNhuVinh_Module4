package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list_blog")
    public ResponseEntity<Page<Blog>> listBlog(@PageableDefault(size = 2) Pageable pageable,
                                               @RequestParam Optional<String> keyword) {

        String title = keyword.orElse("");
        Page<Blog> blogList = this.blogService.findByTitleContaining(title,pageable);
        if (!blogList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


    @GetMapping("/list_category")
    public ResponseEntity<Iterable<Category>> listCategory() {
        List<Category> categoryList = this.categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    //
    @GetMapping("/blog_category/{id}")
    public ResponseEntity<Page<Blog>> blogCategoryId(@PathVariable int id, Pageable pageable) {

        Page<Blog> blogCategoryID = this.blogService.findAllByCategory_IdCategory(id, pageable);

        if (!blogCategoryID.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogCategoryID, HttpStatus.OK);
    }

    @GetMapping("/blogId")
    public ResponseEntity<Blog> blogId(@RequestParam int id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


}
