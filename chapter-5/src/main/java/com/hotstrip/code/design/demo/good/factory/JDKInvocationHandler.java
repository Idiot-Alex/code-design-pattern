package com.hotstrip.code.design.demo.good.factory;

import com.hotstrip.code.design.demo.good.ClassLoaderUtil;
import com.hotstrip.code.design.demo.good.adapter.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hotstrip
 * JDK Invocation Handler
 */
public class JDKInvocationHandler implements InvocationHandler {
    private ICacheAdapter cacheAdapter;
    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(),
                ClassLoaderUtil.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }


}
