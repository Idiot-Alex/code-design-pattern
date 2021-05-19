package com.hotstrip.code.design.award.good;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.award.common.AwardReq;
import com.hotstrip.code.design.award.common.AwardRes;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AwardControllerTest extends TestCase {
    AwardController awardController = new AwardController();

    @Test
    public void testAwardCoupon() {
        // 测试发放优惠券奖励
        log.info("测试发放优惠券奖励....");
        AwardReq awardReq = AwardReq.builder()
                .userId("10001")
                .phone("10000000")
                .bizId("coupon10001")
                .awardType(1)
                .build();
        log.info("请求参数: {}", JSON.toJSONString(awardReq));
        AwardRes awardRes = awardController.awardToUser(awardReq);
        log.info("返回结果: {}", JSON.toJSONString(awardRes));
    }

    @Test
    public void testAwardGoods() {
        // 测试发放实物商品奖励
        log.info("测试发放实物商品奖励....");
        AwardReq awardReq = AwardReq.builder()
                .userId("10001")
                .phone("10000000")
                .bizId("goods10001")
                .awardType(2)
                .build();
        log.info("请求参数: {}", JSON.toJSONString(awardReq));
        AwardRes awardRes = awardController.awardToUser(awardReq);
        log.info("返回结果: {}", JSON.toJSONString(awardRes));
    }

    @Test
    public void testAwardIQiYiCard() {
        // 测试发放爱奇艺虚拟卡奖励
        log.info("测试发放爱奇艺虚拟卡奖励....");
        AwardReq awardReq = AwardReq.builder()
                .userId("10001")
                .phone("10000000")
                .bizId("coupon10001")
                .awardType(3)
                .build();
        log.info("请求参数: {}", JSON.toJSONString(awardReq));
        AwardRes awardRes = awardController.awardToUser(awardReq);
        log.info("返回结果: {}", JSON.toJSONString(awardRes));
    }

    @Test
    public void testAwardError() {
        // 测试发放奖励异常情况
        log.info("测试发放奖励异常情况....");
        AwardReq awardReq = AwardReq.builder()
                .userId("10001")
                .phone("10000000")
                .bizId("coupon10001")
                .build();
        log.info("请求参数: {}", JSON.toJSONString(awardReq));
        AwardRes awardRes = awardController.awardToUser(awardReq);
        log.info("返回结果: {}", JSON.toJSONString(awardRes));
    }
}