package com.example.managementstore.service;

import com.example.managementstore.domain.Price;
import com.example.managementstore.domain.Product;
import com.example.managementstore.infra.PriceSdj;
import com.example.managementstore.infra.ProductSdj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class CreateProductServiceTest {

    @Autowired
    private CreateProductService sut;
    @Autowired
    PriceSdj priceSdj;

    @Autowired
    ProductSdj productSdj;

    public Price price;

    @BeforeEach
    void init() {

        price = Price.builder().id("priceId").firstPrice(10.00).priceAfterDiscounts(5.00).build();

        priceSdj.save(price);

    }

    @Test
    void shouldCreateProduct() {

        Product product = Product.builder().id("test").name("product").prices(Set.of(price)).build();
        sut.createProduct(product);
        Optional<Product> insertedProduct = productSdj.findById("test");
        assertTrue(insertedProduct.isPresent());
        assertEquals("test", insertedProduct.get().getId());

    }

}

