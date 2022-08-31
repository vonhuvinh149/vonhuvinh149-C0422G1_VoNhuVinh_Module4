package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog , Integer> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByCategory_IdCategory(Integer id,Pageable pageable);
}
