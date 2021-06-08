package com.codecool.shop.model;

import java.util.List;

public class ShoppingCart {
    private List<LineItem> lineItems;

    public void addProduct(Product product) {
        LineItem lineItem = new LineItem(product);
        this.lineItems.add(lineItem);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }


    public void removeLineItem(LineItem lineItem){
        this.lineItems.remove(lineItem);
    }
}
