package com.blueochild.route;

import com.blueochild.model.Sale;
import com.blueochild.service.SaleService;
import com.blueochild.datamodel.vo.SalePurchaseVO;
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

    @GetMapping("/{sale_id}")
    @ResponseBody
    public Sale getSale(@PathVariable(value="sale_id") String saleId) throws Exception{
        return this.saleService.find(Integer.parseInt(saleId));
    }

    @GetMapping("/initialize")
    public void initializeSales() {
        this.saleService.initializeSales();
    }

    @PostMapping("/purchase")
    public void purchase(SalePurchaseVO salePurchaseVO) throws Exception {
        int saleId = this.saleService.createSale(salePurchaseVO);
        this.saleService.purchase(saleId);
    }

    @PostMapping("/{sale_id}/refund")
    public void refund(@PathVariable(value="sale_id") String saleId) throws Exception{
        this.saleService.refund(Integer.parseInt(saleId));
    }
}
