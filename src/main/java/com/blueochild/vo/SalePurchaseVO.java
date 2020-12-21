package com.blueochild.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
public class SalePurchaseVO {
    int userId;
    int productId;
    int paidPrice;
    int listPrice;
    int amount;
    @Nullable
    int issuedCouponId;

    @Override
    public String toString() {
        return String.format(
                "SalePurchaseVO[userId=%d, productId=%d, paidPrice=%d, listPrice=%d, amount=%d, issuedCouponId=%d]",
                this.userId, this.productId, this.paidPrice, this.listPrice, this.amount, this.issuedCouponId
        );
    }
}
