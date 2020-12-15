package com.blueochild.route;

import com.blueochild.model.Product;
import com.blueochild.model.Sale;
import com.blueochild.model.User;
import com.blueochild.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    @ResponseBody
    public List<Sale> getSales(){
        return this.saleService.findAll();
    }

    @GetMapping("/{saleId}")
    @ResponseBody
    public Sale GetSale(@PathVariable(value="saleId") String saleId) throws Exception{
        return this.saleService.find(Integer.parseInt(saleId));
    }

    @DeleteMapping("/{saleId}")
    public void deleteSale(@PathVariable(value = "saleId") String saleId){
        this.saleService.deleteSale(Integer.parseInt(saleId));
    }
}
