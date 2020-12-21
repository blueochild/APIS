package com.blueochild.service;

import com.blueochild.model.Product;
import com.blueochild.repository.ProductRepository;
import com.blueochild.vo.ProductRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product find(int productId) throws Exception {
        Optional<Product> searchedProduct = this.productRepository.findById(productId);
        return searchedProduct.orElseThrow(() -> new Exception("해당 상품을 찾지 못하였습니다"));
    }

    public void initializeProducts() {
        Product product1 = Product.builder()
                .name("컴퓨터")
                .description("여러분들이 쓰고 계신겁니다")
                .listPrice(1200000)
                .price(1000000)
                .category("전자기기")
                .imageURL("http://s3.aws-amazon.com/url-computer")
                .build();

        Product product2 = Product.builder()
                .name("갤럭시 s20")
                .description("핸드폰입니다")
                .listPrice(1240000)
                .price(1110000)
                .category("전자기기")
                .imageURL("http://s3.aws-amazon.com/url-galuxy")
                .build();

        Product product3 = Product.builder()
                .name("에어팟 프로")
                .description("달라진 것은 하나, 전부입니다")
                .listPrice(230000)
                .price(210000)
                .category("이어폰")
                .imageURL("http://s3.aws-amazon.com/url-airpod")
                .build();

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
        this.productRepository.flush();
    }

    public int createProduct(ProductRegisterVO productRegisterVO) {
        Product createdProduct = Product.builder()
                .name(productRegisterVO.getName())
                .description(productRegisterVO.getDescription())
                .listPrice(productRegisterVO.getListPrice())
                .price(productRegisterVO.getPrice())
                .category(productRegisterVO.getCategory())
                .imageURL(productRegisterVO.getImageURL())
                .build();

        this.productRepository.save(createdProduct);
        this.productRepository.flush();

        return createdProduct.getProductId();
    }

    public void deleteProduct(int productId) {
        this.productRepository.deleteById(productId);
    }

    public List<Product> productsByCategory(String category) {
        return this.productRepository.findByCategory(category);
    }
}
