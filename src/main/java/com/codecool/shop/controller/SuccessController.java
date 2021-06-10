package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

@WebServlet(urlPatterns = {"/success"})
public class SuccessController  extends HttpServlet {
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        engine.process("payment/success.html", context, resp.getWriter());
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recipient's email ID needs to be mentioned.
        String to = "toge79@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "order@fourhorseman.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();


        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            String title = "Send Email";
            String res = "Sent message successfully....";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<p align = \"center\">" + res + "</p>\n" +
                    "</body></html>"
         );
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}