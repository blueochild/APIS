package com.blueochild.route;

import com.blueochild.model.Product;
import com.blueochild.model.Sale;
import com.blueochild.model.User;
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
    }

    @GetMapping("/initialize")
    public void initializeProducts(){
        this.productService.initializeProduct();
    }

    @GetMapping("")
    @ResponseBody
    public List<Product> getProducts(){
        return this.productService.findAll();
    }

    @GetMapping("/{productId}")
    @ResponseBody
    public Product GetProduct(@PathVariable(value="productId") String productId) throws Exception{
        return this.productService.find(Integer.parseInt(productId));
    }

    @PostMapping("/insert")
    public void ProductInsert(ProductInsertVO product){
        this.productService.productInsert(product);
        System.out.println(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable(value = "productId") String productId){
        this.productService.deleteProduct(Integer.parseInt(productId));
    }
}
