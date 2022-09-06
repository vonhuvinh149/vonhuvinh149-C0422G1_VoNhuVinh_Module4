package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByCategory_IdCategory(Integer id, Pageable pageable);

}
