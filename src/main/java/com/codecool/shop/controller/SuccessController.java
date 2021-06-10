package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.ShoppingCart;
import com.codecool.shop.model.User;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = {"/success"})
public class SuccessController  extends HttpServlet {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String from = "cc.fourhorseman";
        String pass = "Qawsed01";

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ShoppingCartDao shoppingCartDao = ShoppingCartDaoMem.getInstance();
        ProductService productService = new ProductService(productDataStore,productCategoryDataStore, shoppingCartDao);

        HttpSession userSession = request.getSession();
        String userId = userSession.getId();

        User user = productService.getUserById(userId);
        String userEmail = user.getEmail();
        String[] to = { userEmail }; // list of recipient email addresses
        String subject = "Success order!";

        List<Order> orders = productService.getOrderByUserId(userId);
        Order order = orders.get(0);
        ShoppingCart shoppingCart = order.getShoppingCart();

        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(user.getName()).append("!\n\nYour order is:\n\n");
        int index = 1;
        for (LineItem line: shoppingCart.getLineItems()) {
            sb.append("Product " + index++ + ": \n");
            sb.append("name: " + line.getProduct().getName() + "\n");
            sb.append("price: " + line.getProduct().getPrice() + "\n");
            sb.append("quantity: " + line.getQuantity() + "\n");
            sb.append("\n");
        }
        sb.append("Total price: " + shoppingCart.getTotalPrice() + " USD");
        String body = sb.toString();


        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        engine.process("payment/success.html", context, response.getWriter());

    }
}