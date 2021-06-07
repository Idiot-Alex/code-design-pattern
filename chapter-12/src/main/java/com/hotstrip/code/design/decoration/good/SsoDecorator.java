package com.hotstrip.code.design.decoration.good;

import com.hotstrip.code.design.decoration.base.HandlerInterceptor;

/**
 * @author hotstrip
 * 装饰器抽象类
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator() {
    }

    /**
     * 构造函数
     * @param handlerInterceptor
     */
    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    /**
     * 重写拦截方法，交给子类去处理
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
