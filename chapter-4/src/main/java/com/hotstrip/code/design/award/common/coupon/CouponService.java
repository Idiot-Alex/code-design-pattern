package com.hotstrip.code.design.award.common.coupon;

import com.hotstrip.code.design.award.common.AwardRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * Coupon service
 */
@Slf4j
public class CouponService {

    /**
     * send coupon to user
     * @param userId
     * @param phone
     * @param bizId
     * @return
     */
    public AwardRes sendCoupon(String userId, String phone, String bizId) {
        // do something
        log.info("模拟发放优惠券：userId: {}, phone: {}, bizId: {}", userId, phone, bizId);
        return AwardRes.ok();
    }
}
