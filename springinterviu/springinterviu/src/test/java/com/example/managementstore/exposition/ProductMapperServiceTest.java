package com.example.managementstore.exposition;

import com.example.managementstore.domain.Price;
import com.example.managementstore.domain.Product;
import com.example.managementstore.dto.ProductDto;
import com.example.managementstore.service.ConsultPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@SpringBootTest
@ActiveProfiles()
public class ProductMapperServiceTest {

    @Autowired
    private ProductMapperService sut;

    @MockBean
    private ConsultPriceService consultPriceService;

    @Test
    void shouldMapToDomain() {

        ProductDto dto = ProductDto.builder()
                .id("id")
                .name("name")
                .quantity(5)
                .prices(List.of("10"))
                .build();
        when(consultPriceService.consult(any())).thenReturn(Price.builder().id("id").build());

        Product product = sut.mapToDomainForCreate(dto);
        assertNotEquals("message", "id", product.getId());
    }

}
