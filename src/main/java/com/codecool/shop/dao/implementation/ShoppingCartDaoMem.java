package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Product;

import java.util.List;

public class ShoppingCartDaoMem implements ShoppingCartDao {
    private List<Product> products;
    private List<LineItem> lineItems;

    ShoppingCartDaoMem(){

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    @Override
    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    @Override
    public void removeLineItem(LineItem lineItem){
        this.lineItems.remove(lineItem);
    }
}
