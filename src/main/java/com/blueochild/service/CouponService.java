package com.blueochild.service;

import com.blueochild.datamodel.exception.ControllableException;
import com.blueochild.model.Coupon;
import com.blueochild.repository.CouponRepository;
import com.blueochild.datamodel.vo.CouponRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class CouponService {
    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public int createCoupon(CouponRegisterVO couponRegisterVO) throws Exception {
        if (couponRegisterVO.getDiscountPercentage() != 0 && couponRegisterVO.getDiscountPrice() != 0) {
            throw new ControllableException("할인 금액과 할인 비율이 동시에 존재할수 없습니다!");
        }

        Coupon createdCoupon = Coupon.builder()
                .availableDays(couponRegisterVO.getAvailableDays())
                .category(couponRegisterVO.getCategory())
                .discountPercentage(couponRegisterVO.getDiscountPercentage())
                .discountPrice(couponRegisterVO.getDiscountPrice())
                .expireAt(couponRegisterVO.getExpireAt())
                .productID(couponRegisterVO.getProductID())
                .build();

        this.couponRepository.save(createdCoupon);
        this.couponRepository.flush();

        return createdCoupon.getCouponId();
    }

    public Coupon couponById(int couponId) throws Exception {
        Optional<Coupon> coupon = this.couponRepository.findById(couponId);
        
        return coupon.orElseThrow(() -> new ControllableException("해당 쿠폰을 확인할수 없습니다"));
    }
}
