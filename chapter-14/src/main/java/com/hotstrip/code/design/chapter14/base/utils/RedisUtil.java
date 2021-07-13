package com.hotstrip.code.design.chapter14.base.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Redis 工具类
 * 模拟库存消耗
 */
public class RedisUtil {
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtil() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        },0,1000 * 100, TimeUnit.MICROSECONDS);
    }

    /**
     * 获取现在已经使用的库存数量
     * @return
     */
    public int getStockUsed() {
        return stock.get();
    }
}
