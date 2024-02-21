package com.example.managementstore.service;

import com.example.managementstore.domain.Price;
import com.example.managementstore.domain.Product;
import com.example.managementstore.infra.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Set;

@Service
public class ConsultAllProducts {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ConsultPriceService consultPriceService;

    public List<Product> consultAll(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return repository.findAll();
        }
        Set<Price> prices = Set.of(consultPriceService.consult(name));
        return repository.findByNameContaining(name, prices);
    }

}
