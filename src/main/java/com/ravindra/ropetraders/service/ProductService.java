package com.ravindra.ropetraders.service;

import com.ravindra.ropetraders.model.Product;
import com.ravindra.ropetraders.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() { return repo.findAll(); }

    public Product addProduct(Product product) { return repo.save(product); }

    public void deleteProduct(Long id) { repo.deleteById(id); }

    public List<Product> search(String keyword) { return repo.search(keyword); }
}
