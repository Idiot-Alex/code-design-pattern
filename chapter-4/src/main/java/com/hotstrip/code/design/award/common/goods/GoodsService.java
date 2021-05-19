package com.hotstrip.code.design.award.common.goods;

import com.hotstrip.code.design.award.common.AwardRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * Goods service
 */
@Slf4j
public class GoodsService {

    /**
     * send goods award
     * @param userId
     * @param phone
     * @param bizId
     * @return
     */
    public AwardRes deliveryGoods(String userId, String phone, String bizId) {
        // do something
        log.info("模拟发放实物商品：userId: {}, phone: {}, bizId: {}", userId, phone, bizId);
        return AwardRes.ok();
    }
}
