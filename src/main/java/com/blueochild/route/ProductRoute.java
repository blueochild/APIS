package com.blueochild.route;

import com.blueochild.model.Product;
import com.blueochild.service.ProductService;
import com.blueochild.vo.ProductInsertVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    };

    @GetMapping("")
    @ResponseBody
    public List<Product> getProducts() {
        return this.productService.findAll();
    };

    @GetMapping("/{productId}")
    @ResponseBody
    public Product getProduct(@PathVariable(value = "productId") String productId) throws Exception{
        return this.productService.find(Integer.parseInt(productId));
    };

    @GetMapping("/initialize")
    public void initializers() {
        this.productService.initializeProducts();
    };

    @PostMapping("")
    public int ProductInsertVO(ProductInsertVO productInsertVO) {
        return this.productService.ProductInsertVO(productInsertVO);
    };

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable(value = "productId") String productId) {
        this.productService.deleteProduct(Integer.parseInt(productId));
    };
    
    @GetMapping("/category/{categoryName}")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable(value = "categoryName") String categoryName) {
        return this.productService.productsByCategory(categoryName);
    };
};
