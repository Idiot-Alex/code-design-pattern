package com.hotstrip.code.design.chapter16.good;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.chapter16.base.AuthService;
import com.hotstrip.code.design.chapter16.good.impl.Level1AuthLink;
import com.hotstrip.code.design.chapter16.good.impl.Level2AuthLink;
import com.hotstrip.code.design.chapter16.good.impl.Level3AuthLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@Slf4j
public class AuthLinkTest {

    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                .appendNext(new Level1AuthLink("1000011", "张经理")));

        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = format.parse("2021-07-24 00:00:00");

        // 模拟三级审批
        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", currentDate)));
        log.info("测试结果：{}", "模拟三级负责人审批，王工");

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
    }
}