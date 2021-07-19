package com.hotstrip.code.design.chapter14.good;

import com.hotstrip.code.design.chapter14.base.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂
 * @author Hotstrip
 */
public class ActivityFactory {
    static Map<Long, Activity> activityMap = new HashMap<>();

    /**
     * 获取活动信息
     * @param id
     * @return
     */
    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);
        if (null == activity) {
            // 模拟世界业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(id);
            activity.setName("图书嗨了");
            activity.setDesc("图书活动");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}
