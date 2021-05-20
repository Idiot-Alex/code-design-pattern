package com.hotstrip.code.design.demo.bad;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class RedisCacheServiceTest extends TestCase {

    @Test
    public void testRedisCache() {
        RedisCacheService redisCacheService = new RedisCacheServiceImpl();
        log.info("测试 EGM Redis 集群");
        redisCacheService.set("name", "hotstrip", 1);
        String value = redisCacheService.get("name", 1);
        assertEquals("hotstrip", value);

        log.info("测试 IIR Redis 集群");
        redisCacheService.set("name", "hotstrip", 2);
        value = redisCacheService.get("name", 2);
        assertEquals("hotstrip", value);

        log.info("测试 Redis Util");
        redisCacheService.set("name", "hotstrip", 3);
        value = redisCacheService.get("name", 3);
        assertEquals("hotstrip", value);
    }
}