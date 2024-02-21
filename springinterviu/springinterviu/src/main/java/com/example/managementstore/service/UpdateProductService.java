package com.example.managementstore.service;

import com.example.managementstore.domain.Product;
import com.example.managementstore.infra.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConsultProductService consultProductService;


    public void updateProduct(Product newProductData){
        Product persistedProduct = consultProductService.consult(newProductData.getId());
        persistedProduct.setName(newProductData.getName());
        persistedProduct.setPrices(newProductData.getPrices());
        persistedProduct.setBarcode(newProductData.getBarcode());
        persistedProduct.setQuantity(newProductData.getQuantity());

        productRepository.createOrUpdateProduct(persistedProduct);
    }

}
