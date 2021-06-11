package com.codecool.shop.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<LineItem> lineItems = new ArrayList<>();
    private float totalPrice;

    public ShoppingCart(Product product){
        addProduct(product);
    }


    public void addProduct(Product product) {
        if (getLineItemByProduct(product) != null){
            LineItem lineItem = getLineItemByProduct(product);
            lineItem.increaseQuantity(1);
        } else {
            LineItem lineItem = new LineItem(product);
            this.lineItems.add(lineItem);
        }
        String[] str = product.getPrice().split(" ");
        totalPrice += Float.parseFloat(str[0]);
    }

    public void removeProduct(Product product){
        if(getLineItemByProduct(product) != null) {
            LineItem lineItem = getLineItemByProduct(product);
            lineItem.decreaseQuantity(1);
        }else{
            LineItem lineItem = new LineItem(product);
            this.lineItems.remove(lineItem);
        }

    }

    public LineItem getLineItemByProduct(Product product){
        return lineItems.stream().filter(t -> t.getProduct().getId() == product.getId()).findFirst().orElse(null);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public LineItem getLineItemsFirst() {
        return lineItems.get(0);
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void removeLineItem(LineItem lineItem){
        this.lineItems.remove(lineItem);
    }
}
