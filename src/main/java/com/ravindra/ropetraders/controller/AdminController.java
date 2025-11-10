package com.ravindra.ropetraders.controller;

import com.ravindra.ropetraders.model.Product;
import com.ravindra.ropetraders.service.ProductService;
import com.ravindra.ropetraders.service.SupabaseStorageService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ProductService productService;
    private final SupabaseStorageService storageService;

    public AdminController(ProductService productService, SupabaseStorageService storageService) {
        this.productService = productService;
        this.storageService = storageService;
    }

    // Upload image file to Supabase and return URL
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        return storageService.uploadFile(file);
    }

    // Add product with image URL
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.all();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product updated = productService.update(id, updatedProduct);
        return ResponseEntity.ok(updated);
    }

}
