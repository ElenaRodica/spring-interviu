package com.example.managementstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_BARCODE")
    private String barcode;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCTS_PRICES",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRICE_ID"))
    private Set<Price> prices = new HashSet<>();

    @Column(name = "QUANTITY")
    private Integer quantity;

}
