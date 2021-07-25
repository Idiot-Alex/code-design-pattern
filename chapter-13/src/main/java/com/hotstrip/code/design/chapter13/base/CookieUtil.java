package com.hotstrip.code.design.chapter13.base;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Cookie 工具类
 * @author Hotstrip
 */
public class CookieUtil {

    /**
     * 从 HttpServletRequest 里面获取 Cookies
     * @param httpServletRequest
     * @return
     */
    public static List<Cookie> getCookies(HttpServletRequest httpServletRequest) { List<Cookie> list = new ArrayList<>();
        Optional<Cookie[]> optional = Optional.ofNullable(httpServletRequest.getCookies());
        if (optional.isPresent()) {
            list = Arrays.stream(optional.get())
                    .filter(cookie -> null != cookie)
                    .collect(Collectors.toList());
        }
        return list;
    }
}
