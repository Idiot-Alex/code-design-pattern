package com.hotstrip.code.design.adapter.good;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.adapter.base.model.Account;
import com.hotstrip.code.design.adapter.base.model.OrderMQ;
import com.hotstrip.code.design.adapter.good.service.OrderAdapterService;
import com.hotstrip.code.design.adapter.good.service.impl.InsideOrderAdapterServiceImpl;
import com.hotstrip.code.design.adapter.good.service.impl.POPOrderAdapterServiceImpl;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

@Slf4j
public class MQAdapterTest extends TestCase {

    /**
     * 测试不同的消息适配
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Account account = new Account();
        account.setNumber("1000001");
        account.setAddress("河北省，廊坊市，广阳区，大学里职业技术学院");
        account.setAccountDate(new Date());
        account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");

        RebateInfo rebateInfo01 = MQAdapter.filter(JSON.toJSONString(account), link01);
        log.info("account 适配前：{}", JSON.toJSONString(account));
        log.info("account 适配后：{}", JSON.toJSONString(rebateInfo01));

        log.info("-------------\r\n");

        OrderMQ orderMQ = new OrderMQ();
        orderMQ.setUid("1000001");
        orderMQ.setSku("10928092093111123");
        orderMQ.setOrderId("1000000890193847111");
        orderMQ.setCreateOrderTime(new Date());

        HashMap<String, String> link02 = new HashMap<>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");

        RebateInfo rebateInfo02 = MQAdapter.filter(JSON.toJSONString(orderMQ), link02);
        log.info("orderMQ 适配前：{}", JSON.toJSONString(orderMQ));
        log.info("orderMQ 适配后：{}", JSON.toJSONString(rebateInfo02));
    }

    @Test
    public void testAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        log.info("判断首单，接口适配：{}", popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderAdapterService = new InsideOrderAdapterServiceImpl();
        log.info("判断首单，接口适配：{}", insideOrderAdapterService.isFirst("1000001"));
    }

}