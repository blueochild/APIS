package com.blueochild.service;

import com.blueochild.model.Sale;
import com.blueochild.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void initializeSale(){
        Sale user1 = Sale.builder()
                .userId(1)
                .productId(1)
                .paidPrice(1200000)
                .listPrice(1000000)
                .amount(1)
                .build();

        Sale user2 = Sale.builder()
                .userId(2)
                .productId(2)
                .paidPrice(1110000 * 2)
                .listPrice(1240000 * 2)
                .amount(2)
                .build();

        Sale user3 = Sale.builder()
                .userId(3)
                .productId(3)
                .paidPrice(230000 * 3)
                .listPrice(210000 * 3)
                .amount(3)
                .build();

        this.saleRepository.save(user1);
        this.saleRepository.save(user2);
        this.saleRepository.save(user3);
        this.saleRepository.flush();
    }
}
