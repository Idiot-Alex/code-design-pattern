package com.hotstrip.code.design.demo.bad;

import java.util.concurrent.TimeUnit;

/**
 * @author hotstrip
 * redis cache service interface
 */
public interface RedisCacheService {
    String get(final String key, final int redisType);

    void set(final String key, final String value, final int redisType);

    void set(final String key, final String value, final long timeout, final TimeUnit timeUnit, final int redisType);

    void del(final String key, final int redisType);
}
