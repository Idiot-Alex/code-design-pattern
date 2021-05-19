package com.hotstrip.code.design.award.good.factory.award;

import com.hotstrip.code.design.award.common.AwardRes;

/**
 * @author hotstrip
 * Award interface
 */
public interface IAwardService {
    AwardRes awardToUser(String userId, String phone, String bizId);
}
