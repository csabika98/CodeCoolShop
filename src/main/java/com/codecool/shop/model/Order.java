package com.codecool.shop.model;

public class Order {
    private User user;
    private ShoppingCart shoppingCart;

    public Order(User user, ShoppingCart shoppingCart) {
        this.user = user;
        this.shoppingCart =shoppingCart;
}
}
