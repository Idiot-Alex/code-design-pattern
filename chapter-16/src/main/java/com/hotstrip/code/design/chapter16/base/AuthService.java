package com.hotstrip.code.design.chapter16.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟审批的 service
 * @author Hotstrip
 * @date 2021-07-22
 */
@Slf4j
public class AuthService {

    /**
     * 记录审批的记录信息，模拟数据库
     */
    private static Map<String, Date> authMap = new ConcurrentHashMap<>();

    /**
     * 模拟查询审批结果
     * @param userId
     * @param orderId
     * @return
     */
    public static Date queryAuthInfo(String userId, String orderId) {
        return authMap.get(userId.concat(orderId));
    }

    /**
     * 模拟审批过程，添加到 map 对象中
     * @param userId
     * @param orderId
     */
    public static void auth(String userId, String orderId) {
        authMap.put(userId.concat(orderId), new Date());
    }

}
