package com.codegym.service.impl;

import com.codegym.common.NotFoundBook;
import com.codegym.common.NotMaxBook;
import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findByBookNameContaining(String name, Pageable pageable) {
        return bookRepository.findByBookNameContaining(name, pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) throws NotFoundBook, NotMaxBook {
        if (book.getAmountBook() > 0) {
            book.setAmountBook(book.getAmountBook() - 1);
            book.setBorrowAll(book.getBorrowAll() + 1);
            this.bookRepository.save(book);
        } else {
            throw new NotFoundBook();
        }

        if (book.getAmountBook() < book.getTotalBook()) {
            book.setAmountBook(book.getAmountBook() + 1);
        } else {
            throw new NotMaxBook();
        }
    }


}
