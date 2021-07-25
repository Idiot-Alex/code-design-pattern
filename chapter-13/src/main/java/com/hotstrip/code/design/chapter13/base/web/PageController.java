package com.hotstrip.code.design.chapter13.base.web;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.chapter13.base.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 返回页面的 controller
 * @author Hotstrip
 */
@Slf4j
@Controller
public class PageController {

    /**
     * 返回页面
     * @return
     */
    @RequestMapping(value = {"/", "/index"})
    public String indexPage(HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse,
                            String del) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(new Date());
        log.info("接收到页面请求 /index...当前时间: {}", dateStr);
        List<Cookie> list = CookieUtil.getCookies(httpServletRequest);
        log.info("cookie: {}", JSON.toJSONString(list));
        if (StringUtils.hasLength(del)) {
            log.info("删除 cookie route......");
            Cookie cookie = new Cookie("route", null);
            httpServletResponse.addCookie(cookie);
        }
        return "index";
    }
}
