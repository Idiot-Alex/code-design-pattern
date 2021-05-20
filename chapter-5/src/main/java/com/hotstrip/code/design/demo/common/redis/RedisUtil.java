package com.hotstrip.code.design.demo.common.redis;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author hotstrip
 * Redis util
 */
@Slf4j
public class RedisUtil {
    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    /**
     * get key value
     * @param key
     * @return
     */
    public String get(final String key) {
        log.info("Redis 获取数据 key: {}", key);
        return dataMap.get(key);
    }

    /**
     * set key value
     * @param key
     * @param value
     */
    public void set(final String key, final String value) {
        log.info("Redis 写入数据 key: {}, value: {}", key, value);
        dataMap.put(key, value);
    }

    /**
     * set key value with timeout
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void set(final String key, final String value, final long timeout, final TimeUnit timeUnit) {
        log.info("Redis 写入数据 key: {}, value: {}, timeout: {}, timeUnit: {}",
                key, value, timeout, timeUnit);
        dataMap.put(key, value);
    }

    /**
     * delete key
     * @param key
     */
    public void del(final String key) {
        log.info("Redis 删除 key: {}", key);
        dataMap.remove(key);
    }
}
