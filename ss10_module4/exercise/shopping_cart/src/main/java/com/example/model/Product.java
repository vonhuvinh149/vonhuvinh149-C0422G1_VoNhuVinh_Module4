package com.example.model;

import javax.persistence.*;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeProduct;
    private String name;
    private Integer quantity;
    private Double price;
    private String img;

    public Product() {
    }

    public Product(Integer id, String code, String name, Integer quantity, Double price, String url) {
        this.id = id;
        this.codeProduct = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.img = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String url) {
        this.img = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String code) {
        this.codeProduct = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

