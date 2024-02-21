package com.example.managementstore.service;

import com.example.managementstore.domain.Product;
import com.example.managementstore.domain.UnknownObjectException;
import com.example.managementstore.infra.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultProductService {
    @Autowired
    ProductRepository repository;

    public Product consult(String id) {
        Optional<Product> productOptional = repository.findById(id);

        if (productOptional.isPresent()) {
            return productOptional.get();
        }

        throw new UnknownObjectException();
    }
}
