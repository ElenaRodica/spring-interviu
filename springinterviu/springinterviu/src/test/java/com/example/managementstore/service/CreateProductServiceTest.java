/*package com.example.managementstore.service;

import com.example.managementstore.domain.Price;
import com.example.managementstore.domain.Product;
import com.example.managementstore.infra.PriceSdj;
import com.example.managementstore.infra.ProductSdj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


 */
/*import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
public class CreateProductServiceTest {

    @Autowired
    private CreateProductService sut;
    @Autowired
    ProductSdj productSdj;

    private Product product;
    private Price price;

    @Autowired
    PriceSdj priceSdj;

    @BeforeEach
    void init() {

        price = Price.builder()
                .firstPrice(10.00)
                .priceAfterDiscounts(5.00)
                .build();

        priceSdj.save(price);

    }

    @Test
    void shouldCreateProduct() {

        product = Product.builder()
                .id("test")
                .name("product")
                .prices(Set.of(price))
                .build();


    }

}


 */
