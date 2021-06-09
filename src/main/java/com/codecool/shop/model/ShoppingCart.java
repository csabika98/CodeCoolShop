package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<LineItem> lineItems = new ArrayList<>();
    private LineItem lineItem;

    public ShoppingCart(Product product){
        addProduct(product);
    }
    public void addProduct(Product product) {
        if (getLineItemByProduct(product) != null){
            lineItem = new LineItem(product);
        } else {
            lineItem = getLineItemByProduct(product);
        }
        this.lineItems.add(lineItem);
    }

    public LineItem getLineItemByProduct(Product product){
        return lineItems.stream().filter(t -> t.getProduct() == product).findFirst().orElse(null);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }


    public void removeLineItem(LineItem lineItem){
        this.lineItems.remove(lineItem);
    }
}
