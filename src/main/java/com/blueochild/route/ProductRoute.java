package com.blueochild.route;

import com.blueochild.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRoute {

    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/initialize")
    public void initializeProducts(){
        this.productService.initializeProduct();
    }
}
