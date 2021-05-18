package com.hotstrip.code.design.award.bad;

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
        AwardRes awardRes = null;
        // 判断奖品类型
        if (awardReq.getAwardType() == 1) {

        } else if (awardReq.getAwardType() == 2) {

        } else if (awardReq.getAwardType() == 3) {

        } else {

        }
        return null;
    }
}
