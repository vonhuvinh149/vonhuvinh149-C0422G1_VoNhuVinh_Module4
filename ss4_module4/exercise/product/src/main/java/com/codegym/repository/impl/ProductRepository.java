package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "phone", 120000, "oke", "samsung"));
        products.put(2, new Product(2, "radio", 120000, "oke", "sida"));
        products.put(3, new Product(3, "car", 120000, "oke", "yamaha"));
        products.put(4, new Product(4, "moto", 120000, "oke", "honda"));
        products.put(5, new Product(5, "cf", 120000, "oke", "trung nguyen"));
        products.put(6, new Product(6, "rice", 120000, "oke", "rice"));
    }


    @Override
    public List<Product> findAll() {
        List<Product> productsList = new ArrayList<>(products.values());
        return productsList;
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

}
