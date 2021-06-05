package com.hotstrip.code.design.decoration.bad;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LoginSsoDecorationTest extends TestCase {

    @Test
    public void test() {
        LoginSsoDecoration loginSsoDecoration = new LoginSsoDecoration();
        String request = "1successhuahua";
        boolean success = loginSsoDecoration.preHandle(request, "ewcdqt40liuliu", "t");
        log.info("登录校验...request: {}, success: {}", request, success);
    }
}