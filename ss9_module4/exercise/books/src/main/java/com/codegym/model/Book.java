package com.codegym.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "amount_book")
    private int amountBook;
    @Column(name = "content_book")
    private String contentBook;
    @Column(name = "all_borrow")
    private int borrowAll;
    @Column(name = "total_book")
    private int totalBook;

    public Book() {
    }

    public Book(int idBook, String bookName, int amountBook, String contentBook, int borrowAll, int totalBook) {
        this.idBook = idBook;
        this.bookName = bookName;
        this.amountBook = amountBook;
        this.contentBook = contentBook;
        this.borrowAll = borrowAll;
        this.totalBook = totalBook;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAmountBook() {
        return amountBook;
    }

    public void setAmountBook(int amountBook) {
        this.amountBook = amountBook;
    }

    public String getContentBook() {
        return contentBook;
    }

    public void setContentBook(String contentBook) {
        this.contentBook = contentBook;
    }

    public int getBorrowAll() {
        return borrowAll;
    }

    public void setBorrowAll(int borrowAll) {
        this.borrowAll = borrowAll;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }
}
