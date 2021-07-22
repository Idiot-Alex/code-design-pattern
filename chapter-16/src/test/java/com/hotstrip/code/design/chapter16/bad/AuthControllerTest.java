package com.hotstrip.code.design.chapter16.bad;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.chapter16.base.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * 测试类
 */
@Slf4j
public class AuthControllerTest {

    @Test
    public void testAuthController() throws ParseException {
        AuthController authController = new AuthController();

        // 模拟三级审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        AuthService.auth("1000013", "1000998004813441");

        // 模拟二级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        AuthService.auth("1000012", "1000998004813441");

        // 模拟一级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        AuthService.auth("1000011", "1000998004813441");

        log.info("测试结果：{}", "审批完成");
    }
}