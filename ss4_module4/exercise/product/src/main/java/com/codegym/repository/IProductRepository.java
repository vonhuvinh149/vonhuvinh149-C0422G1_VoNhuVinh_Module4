package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> searchProductByName(String searchName);
}
