package com.hotstrip.code.design.award.good.factory.award;

import com.hotstrip.code.design.award.common.AwardRes;
import com.hotstrip.code.design.award.common.goods.GoodsService;

/**
 * @author hotstrip
 * goods award service
 */
public class GoodsAwardService implements IAwardService {

    private GoodsService goodsService = new GoodsService();

    @Override
    public AwardRes awardToUser(String userId, String phone, String bizId) {
        return goodsService.deliveryGoods(userId, phone, bizId);
    }
}
