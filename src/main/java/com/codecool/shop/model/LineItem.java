package com.codecool.shop.model;

public class LineItem {
    private String productName;
    private String supplier;
    private String productPrice;
    private String linePrice;
    private transient Product product;
    private int quantity;
    private float price;

    public LineItem(Product product){
        this.productName = product.getName();
        this.supplier = product.getSupplierName();
        this.product = product;
        this.productPrice = product.getPrice();
        this.linePrice = String.format("%.02f", price);
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
