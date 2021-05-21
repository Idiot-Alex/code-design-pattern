package com.hotstrip.code.design.demo.good.factory;

import com.hotstrip.code.design.demo.good.adapter.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hotstrip
 * factory class
 */
public class JDKProxyFactory {

    public static <T> T getProxy(Class cacheClass, Class<? extends ICacheAdapter> cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{cacheClass}, handler);
    }
}
