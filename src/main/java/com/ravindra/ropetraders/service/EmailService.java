package com.ravindra.ropetraders.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendInquiryMail(String name, String email, String phone, String product, String message) {
        String subject = "New Product Inquiry: " + product;
        String body = String.format("""
                Customer Name: %s
                Email: %s
                Phone: %s
                Message: %s
                """, name, email, phone, message);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("sanyamtheking@gmail.com");
        mail.setSubject(subject);
        mail.setText(body);
        mailSender.send(mail);
    }
}
