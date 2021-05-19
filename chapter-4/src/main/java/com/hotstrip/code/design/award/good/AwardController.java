package com.hotstrip.code.design.award.good;

import com.hotstrip.code.design.award.common.AwardReq;
import com.hotstrip.code.design.award.common.AwardRes;
import com.hotstrip.code.design.award.common.card.IQiYiCardService;
import com.hotstrip.code.design.award.common.coupon.CouponService;
import com.hotstrip.code.design.award.common.goods.GoodsService;
import com.hotstrip.code.design.award.good.factory.AwardFactory;
import com.hotstrip.code.design.award.good.factory.award.IAwardService;
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
        AwardFactory awardFactory = new AwardFactory();
        IAwardService awardService = awardFactory.getAwardService(awardReq.getAwardType());
        if (null == awardService) {
            return AwardRes.error(100, "没有合适的奖品");
        }
        return awardService.awardToUser(awardReq.getUserId(), awardReq.getPhone(), awardReq.getBizId());
    }

}
