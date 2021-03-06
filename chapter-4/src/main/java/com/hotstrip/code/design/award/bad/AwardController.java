package com.hotstrip.code.design.award.bad;

import com.hotstrip.code.design.award.common.AwardReq;
import com.hotstrip.code.design.award.common.AwardRes;
import com.hotstrip.code.design.award.common.card.IQiYiCardService;
import com.hotstrip.code.design.award.common.coupon.CouponService;
import com.hotstrip.code.design.award.common.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * Send Award controller class
 */
@Slf4j
public class AwardController {

    /**
     * send award to user
     * there are some awards: coupon, goods and IQiYiCard
     * @param awardReq
     * @return {@linkplain AwardRes}
     */
    public AwardRes awardToUser(AwardReq awardReq) {
        log.info("奖品发放开始....userId: {}, phone: {}", awardReq.getUserId(), awardReq.getPhone());
        if (null == awardReq.getAwardType()) {
            return AwardRes.error(100, "没有合适的奖品");
        }
        // 判断奖品类型
        if (awardReq.getAwardType() == 1) {
            CouponService couponService = new CouponService();
            return couponService.sendCoupon(awardReq.getUserId(), awardReq.getPhone(), awardReq.getBizId());
        } else if (awardReq.getAwardType() == 2) {
            GoodsService goodsService = new GoodsService();
            return goodsService.deliveryGoods(awardReq.getUserId(), awardReq.getPhone(), awardReq.getBizId());
        } else if (awardReq.getAwardType() == 3) {
            IQiYiCardService iQiYiCardService = new IQiYiCardService();
            return iQiYiCardService.sendvirtualCard(awardReq.getUserId(), awardReq.getPhone(), awardReq.getBizId());
        }
        return AwardRes.error(100, "没有合适的奖品");
    }
}
