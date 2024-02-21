package com.example.managementstore.infra;

import com.example.managementstore.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceSdj extends JpaRepository<Price, String> {

}
