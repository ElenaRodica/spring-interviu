package com.example.managementstore.exposition;

import com.example.managementstore.domain.Product;
import com.example.managementstore.dto.ProductDto;
import com.example.managementstore.service.ConsultPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductMapperService {

    @Autowired
    private ConsultPriceService priceService;



   public Product mapToDomainForCreate(ProductDto dto) {
        Product product = mapToDomain(dto);
        product.setId(UUID.randomUUID().toString());
        return product;
    }

   public Product mapToDomainForUpdate(ProductDto dto, String productId) {
        Product product = mapToDomain(dto);
        product.setId(productId);
        return product;
    }

    private Product mapToDomain(ProductDto dto) {

        return Product.builder()
                .name(dto.name)
                .prices(dto.prices.stream().map( price -> priceService.consult(price)).collect(Collectors.toSet()))
                .barcode(dto.barcode)
                .quantity(dto.quantity)
                .build();
    }



   public ProductDto mapFromDomain(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .barcode(product.getBarcode())
                .prices(product.getPrices().stream().map(price -> price.getFirstPrice() + "").collect(Collectors.toList()))
                .quantity(product.getQuantity())

                .build();
    }


}
