package com.blueochild.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(length = 80, nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private int ListPrice;

    @Column
    private int price;

    @Builder
    public Product(String name, String description, int ListPrice, int price){
        this.name = name;
        this.description = description;
        this.ListPrice = ListPrice;
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format(
                "Product[productId='%s', name='%s', description='%s', listPrice=%d, pridce=%d]",
                this.productId, this.name,this.description, this.ListPrice, this.price
        );
    }
}
