package com.codecool.shop.model;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private List<LineItem> lineItems;


    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    public void removeLineItem(LineItem lineItem){
        this.lineItems.remove(lineItem);
    }
}
