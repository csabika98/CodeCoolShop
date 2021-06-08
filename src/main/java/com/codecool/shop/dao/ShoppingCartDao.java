package com.codecool.shop.dao;

import com.codecool.shop.model.ShoppingCart;


public interface ShoppingCartDao {
    void addProduct(String userId, ShoppingCart shoppingCart);
    ShoppingCart find(String userId);
}
