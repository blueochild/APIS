package com.blueochild.service;

import com.blueochild.datamodel.exception.ControllableException;
import com.blueochild.model.Coupon;
import com.blueochild.model.IssuedCoupon;
import com.blueochild.util.DateUtil;
import com.blueochild.repository.CouponRepository;
import com.blueochild.repository.IssuedCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Optional;

@Controller
public class IssuedCouponService {
    private final IssuedCouponRepository issuedCouponRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public IssuedCouponService(IssuedCouponRepository issuedCouponRepository, CouponRepository couponRepository) {
        this.issuedCouponRepository = issuedCouponRepository;
        this.couponRepository = couponRepository;
    }

    public IssuedCoupon issueCouponById(int issueCouponId) throws Exception {
        return this.issuedCouponRepository.findById(issueCouponId)
                .orElseThrow(() -> new ControllableException("해당 발급된 쿠폰 ID가 없습니다"));
    }

    public int issueCoupon(int couponId, int userId) throws Exception {
        Optional<Coupon> SearchedCoupon = this.couponRepository.findById(couponId);
        Coupon coupon = SearchedCoupon.orElseThrow(() -> new ControllableException("해당 쿠폰을 찾지 못하였습니다."));

        Date expireDate = null;
        Date addedDate = DateUtil.addDays(new Date(), coupon.getAvailableDays());

        int compareDate = addedDate.compareTo(coupon.getExpireAt());
        if (compareDate == 1) {
            expireDate = coupon.getExpireAt();
        }
        else if (compareDate == -1){
            expireDate = addedDate;
        }
        else {
            expireDate = addedDate;
        }

        IssuedCoupon issuedCoupon = IssuedCoupon.builder()
                .couponId(couponId)
                .expiredAt(expireDate)
                .userId(userId)
                .build();

        this.issuedCouponRepository.save(issuedCoupon);
        this.issuedCouponRepository.flush();

        return issuedCoupon.getIssuedCouponId();
    }

}
