package com.hotstrip.code.design.chapter14.good;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.chapter14.base.Activity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class ActivityControllerTest {

    private ActivityController activityController = new ActivityController();

    @Test
    public void testQueryActivityINfo() throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 1000L;
            Activity activity = activityController.queryActivityInfo(req);
            log.info("测试结果：{}, {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }
    }

}