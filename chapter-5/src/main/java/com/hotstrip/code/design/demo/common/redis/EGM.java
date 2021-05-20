package com.hotstrip.code.design.demo.common.redis;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author hotstrip
 * another redis cluster
 */
@Slf4j
public class EGM {
    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    /**
     * get key value
     * @param key
     * @return
     */
    public String gain(final String key) {
        log.info("EGM 获取数据 key: {}", key);
        return dataMap.get(key);
    }

    /**
     * set key value
     * @param key
     * @param value
     */
    public void set(final String key, final String value) {
        log.info("EGM 写入数据 key: {}, value: {}", key, value);
        dataMap.put(key, value);
    }

    /**
     * set key value with timeout
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void setEx(final String key, final String value, final long timeout, final TimeUnit timeUnit) {
        log.info("EGM 写入数据 key: {}, value: {}, timeout: {}, timeUnit: {}",
                key, value, timeout, timeUnit);
        dataMap.put(key, value);
    }

    /**
     * delete key
     * @param key
     */
    public void delete(final String key) {
        log.info("Redis 删除 key: {}", key);
        dataMap.remove(key);
    }
}
