package com.hotstrip.code.design.chapter16.good.impl;

import com.hotstrip.code.design.chapter16.base.AuthInfo;
import com.hotstrip.code.design.chapter16.base.AuthService;
import com.hotstrip.code.design.chapter16.good.AuthLink;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 三级审批流程
 * @author Hotstrip
 */
@Slf4j
public class Level3AuthLink extends AuthLink {
    public Level3AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    /**
     * 实现三级审批流程
     * @param userId
     * @param orderId
     * @param authDate
     * @return
     */
    @Override
    public AuthInfo doAuth(String userId, String orderId, Date authDate) {
        // 模拟三级审批
        Date date = AuthService.queryAuthInfo(super.getLevelUserId(), orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号： ", orderId, " 状态，待三级负责人审批", "王工");
        }
        // 下一级审批
        AuthLink next = super.getNext();
        if (null == next) {
            return new AuthInfo("0000", "单号： ", orderId, " 状态，三级负责人审批完成", " 时间：", format.format(date), " 审批人：", super.getLevelUserName());
        }
        return next.doAuth(userId, orderId, authDate);
    }
}
