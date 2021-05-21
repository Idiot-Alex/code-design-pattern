package com.hotstrip.code.design.demo.good.factory;

import com.hotstrip.code.design.demo.common.CacheService;
import com.hotstrip.code.design.demo.common.redis.IIR;
import com.hotstrip.code.design.demo.good.adapter.EGMCacheAdapter;
import com.hotstrip.code.design.demo.good.adapter.IIRCacheAdapter;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class JDKProxyFactoryTest extends TestCase {

    @Test
    public void testProxyRedisCache() throws Exception {
        CacheService proxyEGM = JDKProxyFactory.getProxy(CacheService.class, EGMCacheAdapter.class);
        log.info("测试 EGM Redis 集群");
        proxyEGM.set("name", "hotstrip");
        String value = proxyEGM.get("name");
        assertEquals("hotstrip", value);

        CacheService proxyIIR = JDKProxyFactory.getProxy(CacheService.class, IIRCacheAdapter.class);
        log.info("测试 IIR Redis 集群");
        proxyIIR.set("name", "hotstrip");
        value = proxyIIR.get("name");
        assertEquals("hotstrip", value);
    }
}