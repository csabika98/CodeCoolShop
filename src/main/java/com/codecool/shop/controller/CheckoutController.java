package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.BillingAddress;
import com.codecool.shop.model.ShippingAddress;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    // ORDER CHECKOUT
    @WebServlet(urlPatterns = {"/checkout"})
    public class CheckoutController extends HttpServlet {
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
            WebContext context = new WebContext(req, resp, req.getServletContext());
            engine.process("checkout/checkout.html", context, resp.getWriter());
        }
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String bilCountry = req.getParameter("bilCountry");
            String bilCity = req.getParameter("bilCity");
            int bilZip = Integer.parseInt(req.getParameter("bilZip"));
            String bilStreet = req.getParameter("bilStreet");
            int bilHouse = Integer.parseInt(req.getParameter("bilHouse"));
            String shipCountry = req.getParameter("shipCountry");
            String shipCity = req.getParameter("shipCity");
            int shipZip = Integer.parseInt(req.getParameter("shipZip"));
            String shipStreet = req.getParameter("shipStreet");
            int shipHouse = Integer.parseInt(req.getParameter("shipHouse"));
            BillingAddress newBilling = new BillingAddress(bilCountry, bilCity, bilZip, bilStreet, bilHouse);
            ShippingAddress newShipping = new ShippingAddress(shipCountry, shipCity, shipZip, shipStreet, shipHouse);
            User newUser = new User(firstName, lastName, email, phone, newBilling, newShipping);
//            System.out.println(newUser.toString());

            resp.sendRedirect(req.getContextPath() + "/payment");

        }
    }


