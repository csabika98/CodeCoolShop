package com.codecool.shop.model;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;


    public ShoppingCart(){

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
