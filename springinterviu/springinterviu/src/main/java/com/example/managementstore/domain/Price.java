package com.example.managementstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "PRICE")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    @Id
    @Column(name = "PRICE_ID")
    private String id;

    @Column(name = "FIRST_PRICE")
    private Double firstPrice;

    @Column(name = "PRICE_AFTER_DISCOUNTS")
    private Double priceAfterDiscounts;

    @ManyToMany
    @JoinTable( name= "PRODUCTS_PRICES", joinColumns = @JoinColumn(name= "PRICE_ID"), inverseJoinColumns = @JoinColumn(name="PRODUCT_ID"))
    private Set<Product> products;

}
