package com.hotstrip.code.design.chapter13.base.web;

import com.hotstrip.code.design.chapter13.base.domain.UserInfo;
import com.hotstrip.code.design.chapter13.good.annotation.DoDoor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hotstrip
 * Controller
 */
@Slf4j
@RestController
public class HelloWorldController {

    /**
     * 模拟查询用户信息接口
     * @param userId
     * @return
     */
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @GetMapping(value = "/api/query-user-info")
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo(userId, 19, "上海小胡同");
    }
}
