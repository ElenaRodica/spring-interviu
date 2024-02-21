package com.example.managementstore.infra;

import com.example.managementstore.domain.Price;
import com.example.managementstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ProductRepository {

    @Autowired
    private ProductSdj productSdj;

    public void createOrUpdateProduct(Product product) {
        productSdj.save(product);
    }

    public Optional<Product> findById(String id) {

        return productSdj.findById(id);
    }

    public List<Product> findAll() {
        return productSdj.findAll();
    }

    public void deleteBook(Product product) {
        // productSdj.deleteById(product);
        productSdj.delete(product);
    }

    public List<Product> findByNameContaining(String name, Set<Price> prices) {
        return productSdj.findByNameContainsAndPricesInOrderByNameAsc(name, prices);
    }

}
