package com.hotstrip.code.design.chapter13.base.web;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.chapter13.base.CookieUtil;
import com.hotstrip.code.design.chapter13.base.domain.R;
import com.hotstrip.code.design.chapter13.base.domain.UserInfo;
import com.hotstrip.code.design.chapter13.good.annotation.DoDoor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


    /**
     * 返回当前时间
     * @return
     */
    @GetMapping(value = "/test")
    public Object index(HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse,
                        String del) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(new Date());
        log.info("接收到接口请求...当前时间: {}", dateStr);
        List<Cookie> list = CookieUtil.getCookies(httpServletRequest);
        log.info("cookie: {}", JSON.toJSONString(list));
        if (StringUtils.hasLength(del)) {
            log.info("删除 cookie route......");
            Cookie cookie = new Cookie("route", null);
            httpServletResponse.addCookie(cookie);
        }
        return R.ok(0, "success", dateStr);
    }
}
