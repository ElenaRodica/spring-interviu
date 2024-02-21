package com.example.managementstore.service;

import com.example.managementstore.domain.Price;
import com.example.managementstore.infra.PriceRepository;
import com.example.managementstore.domain.UnknownObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultPriceService {
    @Autowired
    private PriceRepository priceRepository;

    public Price consult(String priceId) {

        return priceRepository.findById(priceId).orElseThrow(UnknownObjectException::new);
    }
}
