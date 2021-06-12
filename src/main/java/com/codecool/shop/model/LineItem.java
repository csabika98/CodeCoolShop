package com.codecool.shop.model;

public class LineItem {
    private String productName;
    private String supplier;
    private String productPrice;
    private String linePrice;
    private transient Product product;
    private int productId;
    private int quantity;
    private float price;

    public LineItem(Product product){
        this.productName = product.getName();
        this.supplier = product.getSupplierName();
        this.product = product;
        this.productId = product.getId();
        this.productPrice = product.getPrice();
        quantity = 1;
        price = product.getDefaultPrice() * quantity;
        this.linePrice = String.format("%.02f", price) + " " + product.getDefaultCurrency().toString();
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
        linePrice = String.format("%.02f", price) + " " + product.getDefaultCurrency().toString();
    }

    public void decreaseQuantity() {
        quantity -= 1;
        price = product.getDefaultPrice() * quantity;
        linePrice = String.format("%.02f", price) + " " + product.getDefaultCurrency().toString();
    }
}
