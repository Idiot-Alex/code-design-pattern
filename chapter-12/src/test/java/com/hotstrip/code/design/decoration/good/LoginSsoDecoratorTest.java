package com.hotstrip.code.design.decoration.good;

import com.hotstrip.code.design.decoration.base.SsoHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class LoginSsoDecoratorTest {

    @Test
    public void testSsoLogin() {
        LoginSsoDecorator loginSsoDecorator = new LoginSsoDecorator(new SsoHandlerInterceptor());
        String request = "1successhuahua";
        boolean success = loginSsoDecorator.preHandle(request, "ewcdqt40liuliu", "t");
        log.info("登录校验...request: {}, success: {}", request, success);
    }

}