package com.ravindra.ropetraders.service;

import com.ravindra.ropetraders.model.Inquiry;
import com.ravindra.ropetraders.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class InquiryService {
  private final InquiryRepository repo;
  private final JavaMailSender mailSender;

  @Value("${app.admin.email}")
  private String adminEmail;

  public InquiryService(InquiryRepository repo, JavaMailSender mailSender) {
    this.repo = repo;
    this.mailSender = mailSender;
  }

  public Inquiry submit(Inquiry in) {
    in.setCreatedAt(LocalDateTime.now());
    Inquiry saved = repo.save(in);

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo(adminEmail);
    msg.setSubject("New Product Enquiry: " + in.getProductName());
    msg.setText("""
        Product: %s
        Name: %s
        Email: %s
        Phone: %s
        Location: %s

        Message:
        %s
        """.formatted(
        in.getProductName(),
        in.getCustomerName(),
        in.getEmail(),
        in.getPhone(),
        in.getLocation(),
        in.getMessage() == null ? "" : in.getMessage()
    ));
    mailSender.send(msg);

    return saved;
  }
}
