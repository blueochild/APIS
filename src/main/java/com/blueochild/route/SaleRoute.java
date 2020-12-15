package com.blueochild.route;

import com.blueochild.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleRoute {

    private final SaleService saleService;

    @Autowired
    public SaleRoute(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/initialize")
    public void initializeSale(){
        this.saleService.initializeSale();
    }
}
