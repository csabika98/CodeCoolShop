package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.ShoppingCart;

import java.util.List;

public class ProductService {
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private ShoppingCartDao shoppingCartDao;

    public ProductService(){
    }

    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao, ShoppingCartDao shoppingCartDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.shoppingCartDao = shoppingCartDao;
    }


    public ProductCategory getProductCategory(int categoryId) {
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId) {
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }
    public ShoppingCart getShoppingCartByUserId(String userID){
        return shoppingCartDao.find(userID);
    }

    public List<ProductCategory> getAllCategory() {
        return productCategoryDao.getAll();
    }

    public List<Product> getSupplierDao(String supplier) {
        return productDao.getBy(supplier);
    }

    public Product getProductById(int productId){
        return productDao.find(productId);
    }

    public void addProductToCart(String userId, int productId){
        Product product = getProductById(productId);
        ShoppingCart shoppingCart;
        if (shoppingCartDao.getAll().containsKey(userId)){
            shoppingCart = shoppingCartDao.find(userId);
            shoppingCart.addProduct(product);
        } else {
            shoppingCart = new ShoppingCart(product);
        }
        shoppingCartDao.addShoppingCart(userId, shoppingCart);
    }

    public void removeProductFromCart(String userId, int productId){
        Product product = getProductById(productId);
        ShoppingCart shoppingCart;
        if(shoppingCartDao.getAll().containsKey(userId)) {
            shoppingCart = shoppingCartDao.find(userId);
            shoppingCart.removeProduct(product);
        }else{
            shoppingCart = new ShoppingCart(product);
        }
        shoppingCartDao.addShoppingCart(userId, shoppingCart);
    }
}