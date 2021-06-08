package com.codecool.shop.model;

public class LineItem {
    private Product product;
    private int quantity;
    private float price;

    public LineItem(Product product){
        this.product = product;
        quantity = 1;
        price = product.getDefaultPrice() * quantity;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int number) {
        quantity += number;
        price = product.getDefaultPrice() * quantity;
    }

    public void decreaseQuantity(int number) {
        quantity -= number;
        price = product.getDefaultPrice() * quantity;
    }
}
