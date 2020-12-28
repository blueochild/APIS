package com.blueochild.route;

import com.blueochild.model.Coupon;
import com.blueochild.model.IssuedCoupon;
import com.blueochild.service.CouponService;
import com.blueochild.service.IssuedCouponService;
import com.blueochild.datamodel.vo.CouponRegisterVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponRoute {
    private final CouponService couponService;
    private final IssuedCouponService issuedCouponService;

    @Autowired
    public CouponRoute(CouponService couponService, IssuedCouponService issuedCouponService) {
        this.couponService = couponService;
        this.issuedCouponService = issuedCouponService;
    }

    @ApiOperation(value = "쿠폰 정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "coupon_id", value = "쿠폰 ID", required = true, dataType = "string",
                    paramType = "query", defaultValue = "")
    })

    @GetMapping("/{coupon_id}")
    @ResponseBody
    public Coupon getCoupon(@PathVariable(value="coupon_id") String couponId) throws Exception {
        return this.couponService.couponById(Integer.parseInt(couponId));
    }

    @PostMapping
    public int createCoupon(CouponRegisterVO couponRegisterVO) throws Exception{
        return this.couponService.createCoupon(couponRegisterVO);
    }

    @PostMapping("/{coupon_id}/issue")
    public int issueCoupon(@PathVariable(value="coupon_id") String couponId,
                           @RequestParam(value="user_id") String userId) throws Exception {
        return this.issuedCouponService.issueCoupon(Integer.parseInt(couponId), Integer.parseInt(userId));
    }

    @GetMapping("/issued-coupon/{issued_coupon_id}")
    @ResponseBody
    public IssuedCoupon getIssuedCoupon(@PathVariable(value="issued_coupon_id") String issuedCouponId) throws Exception{
        return this.issuedCouponService.issueCouponById(Integer.parseInt(issuedCouponId));
    }
}
