package com.hotstrip.code.design.demo.common;

import java.util.concurrent.TimeUnit;

/**
 * @author hotstrip
 * use Redis for cache interface
 */
public interface CacheService {

    String get(final String key);

    void set(final String key, final String value);

    void set(final String key, final String value, final long timeout, final TimeUnit timeUnit);

    void del(final String key);
}
