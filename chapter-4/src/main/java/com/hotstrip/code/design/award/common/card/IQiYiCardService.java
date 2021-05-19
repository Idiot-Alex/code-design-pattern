package com.hotstrip.code.design.award.common.card;

import com.hotstrip.code.design.award.common.AwardRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * IQiYi card service
 */
@Slf4j
public class IQiYiCardService {

    /**
     * send IQiYi virtual card
     * @param userId
     * @param phone
     * @param bizId
     * @return
     */
    public AwardRes sendvirtualCard(String userId, String phone, String bizId) {
        // do something
        log.info("模拟发放爱奇艺虚拟卡：userId: {}, phone: {}, bizId: {}", userId, phone, bizId);
        return AwardRes.ok();
    }
}
