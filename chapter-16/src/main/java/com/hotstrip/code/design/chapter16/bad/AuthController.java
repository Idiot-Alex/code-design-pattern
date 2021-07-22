package com.hotstrip.code.design.chapter16.bad;

import com.hotstrip.code.design.chapter16.base.AuthInfo;
import com.hotstrip.code.design.chapter16.base.AuthService;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟审批的 controller
 */
@Slf4j
public class AuthController {

    // 时间格式化
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AuthInfo doAuth(String userId, String orderId, Date authDate) throws ParseException {
        // 模拟三级审批
        Date date = AuthService.queryAuthInfo("10003", orderId);
        if (null == authDate) {
            return new AuthInfo("0001", "单号： ", orderId, " 状态，待三级负责人审批", "王工");
        }

        // 模拟二级审批
        if (authDate.after(simpleDateFormat.parse("2021-07-23 00:00:00"))
                && authDate.before(simpleDateFormat.parse("2021-07-30 00:00:00"))) {
            date = AuthService.queryAuthInfo("10002", orderId);
            if (null == authDate) {
                return new AuthInfo("0001", "单号： ", orderId, " 状态，待二级负责人审批", "张经理");
            }
        }

        // 模拟一级审批
        if (authDate.after(simpleDateFormat.parse("2021-07-24 00:00:00"))
                && authDate.before(simpleDateFormat.parse("2021-07-25 00:00:00"))) {
            date = AuthService.queryAuthInfo("10002", orderId);
            if (null == authDate) {
                return new AuthInfo("0001", "单号： ", orderId, " 状态，待二级负责人审批", "张经理");
            }
        }

        return new AuthInfo("0001", "单号: ", orderId, " 状态，审批完成");
    }
}
