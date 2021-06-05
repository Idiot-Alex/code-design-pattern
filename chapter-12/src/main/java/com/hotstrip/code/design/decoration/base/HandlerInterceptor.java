package com.hotstrip.code.design.decoration.base;

/**
 * @author hotstrip
 * 拦截器接口
 */
public interface HandlerInterceptor {

    /**
     * 拦截
     * @param request
     * @param response
     * @param handler
     * @return
     */
    boolean preHandle(String request, String response, Object handler);
}
