package com.hotstrip.code.design.decoration.base;

/**
 * @author hotstrip
 * SSO 拦截器
 */
public class SsoHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取 token
        String token = request.substring(1, 8);
        // 模拟校验
        return token.equals("success");
    }
}
