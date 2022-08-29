package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Product, Integer> map = new HashMap<>();

    public Cart(Map<Product, Integer> map) {
        this.map = map;
    }

    public Cart() {
    }

    public Map<Product, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Product, Integer> map) {
        this.map = map;
    }

    private boolean checkInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectCart(Product product) {
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkInCart(product)) {
            map.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectCart(product);
            Integer newAmount = itemEntry.getValue() + 1;
            map.replace(itemEntry.getKey(), newAmount);

        }
    }
}
