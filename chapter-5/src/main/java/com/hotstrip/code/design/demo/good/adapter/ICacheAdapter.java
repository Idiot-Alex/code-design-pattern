package com.hotstrip.code.design.demo.good.adapter;

import java.util.concurrent.TimeUnit;

/**
 * @author hotstrip
 * cache adapter
 */
public interface ICacheAdapter {

    String get(final String key);

    void set(final String key, final String value);

    void set(final String key, final String value, final long timeout, final TimeUnit timeUnit);

    void del(final String key);
}
