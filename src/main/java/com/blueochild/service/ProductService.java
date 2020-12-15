package com.blueochild.service;

import com.blueochild.model.Product;
import com.blueochild.repository.ProductRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void initializeProduct(){
        Product Product1 = Product.builder()
            .name("컴퓨터")
            .description("사용중인 컴퓨터입니다.")
            .ListPrice(1000000)
            .price(1200000)
            .build();

        Product Product2 = Product.builder()
            .name("애플 휴대폰")
            .description("비싼 애플 휴대폰입니다.")
            .ListPrice(1240000)
            .price(1110000)
            .build();

        Product Product3 = Product.builder()
            .name("사과")
            .description("맛있는 사과당")
            .ListPrice(210000)
            .price(230000)
            .build();

        this.productRepository.save(Product1);
        this.productRepository.save(Product2);
        this.productRepository.save(Product3);
        this.productRepository.flush();
    }
}
