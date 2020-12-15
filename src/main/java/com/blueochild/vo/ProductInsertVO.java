package com.blueochild.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductInsertVO {
    private String name;
    private String description;
    private int ListPrice;
    private int price;

    @Override
    public String toString(){
        return String.format(
                "product[name='%s', description='%s', ListPrice=%d, price=%d",
                name, description, ListPrice, price
        );
    }

}
