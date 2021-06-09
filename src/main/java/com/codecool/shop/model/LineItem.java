package com.codecool.shop.model;

public class LineItem {
    private String productName;
    private transient Product product;
    private int quantity;
    private float price;

    public LineItem(Product product){
        this.productName = product.getName();
        this.product = product;
        quantity = 1;
        price = product.getDefaultPrice() * quantity;
    }

    public Product getProduct() {
        return product;
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
