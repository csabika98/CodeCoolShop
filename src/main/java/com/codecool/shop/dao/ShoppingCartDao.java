package com.codecool.shop.dao;

import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;

import java.util.List;

public interface ShoppingCartDao {
    List<Product> getProducts();
    List<LineItem> getLineItems();
    void addProduct(Product product) ;
    void addLineItem(LineItem lineItem);
    void removeLineItem(LineItem lineItem);
}
