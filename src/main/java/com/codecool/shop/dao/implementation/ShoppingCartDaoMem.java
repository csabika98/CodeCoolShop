package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.model.ShoppingCart;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCartDaoMem implements ShoppingCartDao {

    private Map<String, ShoppingCart> allshoppingCart = new LinkedHashMap<>();
    private static ShoppingCartDaoMem instance = null;

    ShoppingCartDaoMem(){
    }

    public static ShoppingCartDaoMem getInstance() {
        if (instance == null) {
            instance = new ShoppingCartDaoMem();
        }
        return instance;
    }

    @Override
    public void addProduct(String userId, ShoppingCart shoppingCart) {
        this.allshoppingCart.put(userId, shoppingCart);
    }

    @Override
    public ShoppingCart find(String userId) {
        return allshoppingCart.get(userId);
    }




}
