package com.codegym.service;

import com.codegym.common.NotFoundBook;
import com.codegym.common.NotMaxBook;
import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);
    Page<Book> findByBookNameContaining(String name, Pageable pageable);
    Book findById(int id);
    void save(Book book) throws Exception, NotMaxBook, NotFoundBook;
}
