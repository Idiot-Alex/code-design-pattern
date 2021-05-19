package com.hotstrip.code.design.award.good.factory.award;

import com.hotstrip.code.design.award.common.AwardRes;
import com.hotstrip.code.design.award.common.coupon.CouponService;

/**
 * @author hotstrip
 * coupon award service
 */
public class CouponAwardService implements IAwardService {

    private CouponService couponService = new CouponService();

    @Override
    public AwardRes awardToUser(String userId, String phone, String bizId) {
        return couponService.sendCoupon(userId, phone, bizId);
    }
}
