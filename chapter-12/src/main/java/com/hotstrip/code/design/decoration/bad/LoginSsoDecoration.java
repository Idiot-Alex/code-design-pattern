package com.hotstrip.code.design.decoration.bad;

import com.hotstrip.code.design.decoration.base.SsoHandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hotstrip
 * 模拟单点登录拦截
 */
public class LoginSsoDecoration extends SsoHandlerInterceptor {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取 token
        String ticket = request.substring(1, 8);
        // 模拟校验
        boolean success = ticket.equals("success");
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
