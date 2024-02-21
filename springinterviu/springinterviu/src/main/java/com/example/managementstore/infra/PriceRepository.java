package com.example.managementstore.infra;

import com.example.managementstore.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PriceRepository {
    @Autowired
    private PriceSdj priceSdj;

    public Optional<Price> findById(String priceId) {
        return priceSdj.findById(priceId);
    }
}
