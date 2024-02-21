package com.example.managementstore.service;

import com.example.managementstore.domain.Product;
import com.example.managementstore.infra.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.createOrUpdateProduct(product);
    }
}
