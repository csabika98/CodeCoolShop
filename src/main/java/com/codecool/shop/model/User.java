package com.codecool.shop.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phone;
    private String password;
    private BillingAddress billingAddress;
    private ShippingAddress shippingAddress;

    public User(String firstName, String lastName, String email, String phone, BillingAddress billingAddress, ShippingAddress shippingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

}
