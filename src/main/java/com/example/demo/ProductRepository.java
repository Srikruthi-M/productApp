package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {

    private Map<Integer, Product> products = new HashMap<>();

    public Product save(Product product) {
        if (product != null && product.getId() != null) {
            products.put(product.getId(), product);
        }
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Product findById(Integer id) {
        return products.get(id);
    }

    public Product deleteById(Integer id) {
        Product removed = products.get(id);
        if (removed != null) {
            products.remove(id);
        }
        return removed;
    }

    public Product update(Product product) {
        if (product != null && products.containsKey(product.getId())) {
            Product existing = products.get(product.getId());
            existing.setName(product.getName());
            existing.setCategory(product.getCategory());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            return existing;
        }
        return null;
    }
}
