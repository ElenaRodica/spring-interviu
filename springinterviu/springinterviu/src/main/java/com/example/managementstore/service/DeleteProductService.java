package com.example.managementstore.service;

import com.example.managementstore.domain.Product;
import com.example.managementstore.infra.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ConsultProductService consultProductService;

    public void deleteProductById(String id){
        Product product = consultProductService.consult(id);
        repository.deleteBook(product);
    }
}
