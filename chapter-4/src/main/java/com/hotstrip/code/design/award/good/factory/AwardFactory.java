package com.hotstrip.code.design.award.good.factory;

import com.hotstrip.code.design.award.good.factory.award.CouponAwardService;
import com.hotstrip.code.design.award.good.factory.award.GoodsAwardService;
import com.hotstrip.code.design.award.good.factory.award.IAwardService;
import com.hotstrip.code.design.award.good.factory.award.IQiYiCardAwardService;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * Award factory class
 */
@Slf4j
public class AwardFactory {

    /**
     * return a AwardService instance with class
     * @param clazz
     * @return
     */
    @SneakyThrows
    public IAwardService getAwardService(@NonNull Class<? extends IAwardService> clazz) {
        return clazz.newInstance();
    }

    /**
     * return a AwardService instance with awardType
     * @param awardType
     * @return
     */
    public IAwardService getAwardService(Integer awardType) {
        if (null == awardType) {
            return null;
        }
        if (1 == awardType) {
            return new CouponAwardService();
        }
        if (2 == awardType) {
            return new GoodsAwardService();
        }
        if (3 == awardType) {
            return new IQiYiCardAwardService();
        }
        log.error("不存在的奖品服务类型");
        return null;
    }
}
