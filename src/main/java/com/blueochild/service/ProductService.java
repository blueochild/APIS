package com.blueochild.service;

import com.blueochild.model.Product;
import com.blueochild.model.User;
import com.blueochild.repository.ProductRepository;
import com.blueochild.vo.ProductInsertVO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product find(int ProductId) throws Exception{
        Optional<Product> searchedProduct = this.productRepository.findById(ProductId);
        return searchedProduct.orElseThrow(() -> new Exception("해당 상품을 찾지 못했습니다."));
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
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

    public void productInsert(ProductInsertVO productInsertVO){
        Product productInsert = Product.builder()
                .name(productInsertVO.getName())
                .description(productInsertVO.getDescription())
                .ListPrice(productInsertVO.getListPrice())
                .price(productInsertVO.getPrice())
                .build();

        this.productRepository.save(productInsert);
    }

    public void deleteProduct(int productId){
        this.productRepository.deleteById(productId);
    }
}
