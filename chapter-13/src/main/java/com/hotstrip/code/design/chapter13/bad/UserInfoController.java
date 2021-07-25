package com.hotstrip.code.design.chapter13.bad;

import com.hotstrip.code.design.chapter13.base.domain.R;
import com.hotstrip.code.design.chapter13.base.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hotstrip
 * 用户相关 api 接口
 */
@Slf4j
@RestController
public class UserInfoController {

    /**
     * 模拟查询用户信息接口
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/bad/query-user-info")
    public Object queryUserInfo(@RequestParam String userId) {
        // 白名单拦截
        List<String> userList = new ArrayList<>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("cccc");

        // 判断白名单
        if (!userList.contains(userId)) {
            log.error("userId: [{}] 不在白名单里面", userId);
            return R.error(100, "不再白名单里面");
        }
        return R.ok(0, "ok", new UserInfo(userId, 19, "上海小胡同"));
    }



}
