package com.hotstrip.code.design.chapter14.good;

import com.hotstrip.code.design.chapter14.base.Activity;
import com.hotstrip.code.design.chapter14.base.Stock;
import com.hotstrip.code.design.chapter14.base.utils.RedisUtil;

/**
 * 活动 controller
 * @author Hotstrip
 */
public class ActivityController {
    private RedisUtil redisUtil = new RedisUtil();

    /**
     * 模拟查询活动信息
     * 其中的库存从 Redis 里面获取
     * @param id
     * @return
     */
    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从 Redis 中获取商品库存变化信息
        Stock stock = new Stock(1000, redisUtil.getStockUsed());
        activity.setStock(stock);

        return activity;
    }
}
