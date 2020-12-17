package com.blueochild.route;

import com.blueochild.model.Sale;
import com.blueochild.service.SaleService;
import com.blueochild.vo.SalePurchaseVO;
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
    };

    @GetMapping("")
    @ResponseBody
    public List<Sale> getSales() {
        return this.saleService.findAll();
    };

    @GetMapping("/{saleId}")
    @ResponseBody
    public Sale getSale(@PathVariable(value = "saleId") String saleId) throws Exception{
        return this.saleService.find(Integer.parseInt(saleId));
    };

    @GetMapping("/initialize")
    public void initializers() {
        this.saleService.initializeSales();
    };

    @PostMapping("/purchase")
    public void purchase(SalePurchaseVO salePurchaseVO) throws Exception {
        int saleId = this.saleService.createSale(salePurchaseVO);
        this.saleService.purchase(saleId);
    };

    @PostMapping("/{saleId}/refund")
    public void refund(@PathVariable(value = "saleId") String saleId) throws Exception{
        this.saleService.refund(Integer.parseInt(saleId));
    };

    public List<Sale> getSalesByUserId(int userId) {
        return this.saleService.findByUserId(userId);
    };
}
