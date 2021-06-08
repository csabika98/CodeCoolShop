package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;

public class Order {
    private User user;
    private ShoppingCartDaoMem shoppingCartDaoMem;

    public Order(User user, ShoppingCartDaoMem shoppingCartDaoMem) {
        this.user = user;
        this.shoppingCartDaoMem = shoppingCartDaoMem;
}
}
