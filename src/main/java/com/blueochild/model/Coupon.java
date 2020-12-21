package com.blueochild.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int couponId;

    @Column
    Date expireAt;

    @Column
    int availableDays;

    @Column
    int productID;

    @Column
    String category;

    @Column
    int discountPrice = 0;

    @Column
    int discountPercentage = 0;

    @Builder
    public Coupon(Date expireAt, int availableDays, int productID,
                  String category, int discountPrice, int discountPercentage) {
        this.expireAt = expireAt;
        this.availableDays = availableDays;
        this.productID = productID;
        this.category = category;
        this.discountPrice = discountPrice;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return String.format(
                "Column[couponId=%d, expireAt='%s', availableDays=%d, productID=%d, category='%s', " +
                        "discountPrice=%d, discountPercentage=%d]",
                this.couponId, this.expireAt, this.availableDays, this.productID,
                this.category, this.discountPrice, this.discountPercentage
        );
    }
}
