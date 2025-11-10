package com.ravindra.ropetraders.controller;

import com.ravindra.ropetraders.model.Inquiry;
import com.ravindra.ropetraders.model.Product;
import com.ravindra.ropetraders.service.InquiryService;
import com.ravindra.ropetraders.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicController {
  private final ProductService productService;
  private final InquiryService inquiryService;

  public PublicController(ProductService productService, InquiryService inquiryService) {
    this.productService = productService;
    this.inquiryService = inquiryService;
  }

  @GetMapping("/products")
  public List<Product> products() {
    return productService.all();
  }

  @GetMapping("/products/search")
  public List<Product> search(@RequestParam String keyword) {
    return productService.search(keyword);
  }

  @PostMapping("/inquiry")
  public Inquiry submitInquiry(@RequestBody Inquiry inquiry) {
    return inquiryService.submit(inquiry);
  }
}
