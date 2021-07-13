package com.hotstrip.code.design.chapter14.bad;

import com.hotstrip.code.design.chapter14.base.Activity;
import com.hotstrip.code.design.chapter14.base.Stock;

import java.util.Date;

/**
 * 活动信息接口类
 * @author hotstrip
 */
public class ActivityController {

    /**
     * 模拟实际业务中从接口中获取活动信息
     * @param id
     * @return
     */
    public Activity queryActivityInfp(Long id) {
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书活动202107");
        activity.setDesc("2021 年 7 月图书活动");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;
    }
}
