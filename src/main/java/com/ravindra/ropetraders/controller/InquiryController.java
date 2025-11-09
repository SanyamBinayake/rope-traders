package com.ravindra.ropetraders.controller;

import com.ravindra.ropetraders.model.Inquiry;
import com.ravindra.ropetraders.repository.InquiryRepository;
import com.ravindra.ropetraders.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inquiry")
@CrossOrigin(origins = "*")
public class InquiryController {
    private final InquiryRepository repo;
    private final EmailService emailService;

    public InquiryController(InquiryRepository repo, EmailService emailService) {
        this.repo = repo;
        this.emailService = emailService;
    }

    @PostMapping
    public Inquiry sendInquiry(@RequestBody Inquiry inquiry) {
        emailService.sendInquiryMail(
                inquiry.getCustomerName(),
                inquiry.getEmail(),
                inquiry.getPhone(),
                inquiry.getProductName(),
                inquiry.getMessage()
        );
        return repo.save(inquiry);
    }
}
