package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id);
    }

    public Product deleteProduct(Integer id) {
        return repository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        return repository.update(product);
    }
}
