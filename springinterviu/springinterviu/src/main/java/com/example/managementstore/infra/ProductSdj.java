package com.example.managementstore.infra;

import com.example.managementstore.domain.Price;
import com.example.managementstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductSdj extends JpaRepository<Product, String> {
    List<Product> findByNameContainsAndPricesInOrderByNameAsc(String name, Set<Price> prices);
}
