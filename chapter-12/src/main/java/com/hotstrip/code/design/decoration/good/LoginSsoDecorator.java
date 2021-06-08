package com.hotstrip.code.design.decoration.good;

import com.hotstrip.code.design.decoration.base.HandlerInterceptor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author  hotstrip
 * SSO 登录
 */
@Slf4j
public class LoginSsoDecorator extends SsoDecorator {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        log.info("模拟单点登录方法访问拦截校验...userId: {} method: {}", userId, method);
        return "queryUserInfo".equals(method);
    }
}
