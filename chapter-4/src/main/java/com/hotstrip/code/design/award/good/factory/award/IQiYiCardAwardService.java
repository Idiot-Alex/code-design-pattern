package com.hotstrip.code.design.award.good.factory.award;

import com.hotstrip.code.design.award.common.AwardRes;
import com.hotstrip.code.design.award.common.card.IQiYiCardService;

/**
 * @author hotstrip
 * IQiYi card award service
 */
public class IQiYiCardAwardService implements IAwardService {

    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public AwardRes awardToUser(String userId, String phone, String bizId) {
        return iQiYiCardService.sendvirtualCard(userId, phone, bizId);
    }
}
