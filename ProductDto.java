package com.example.managementstore.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class ProductDto {

    public String id;
    public String name;
    public String barcode;
    public List<String> prices;
    public Integer quantity;

}
