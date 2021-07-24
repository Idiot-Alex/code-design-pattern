package com.hotstrip.code.design.chapter16.good.impl;

import com.hotstrip.code.design.chapter16.base.AuthInfo;
import com.hotstrip.code.design.chapter16.base.AuthService;
import com.hotstrip.code.design.chapter16.good.AuthLink;

import java.text.ParseException;
import java.util.Date;

/**
 * 一级审批流程
 * @author Hotstrip
 */
public class Level1AuthLink extends AuthLink {

    Date beginDate = format.parse("2021-07-24 00:00:00");
    Date endDate = format.parse("2021-07-25 00:00:00");

    public Level1AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    /**
     * 实现一级审批流程
     * @param userId
     * @param orderId
     * @param authDate
     * @return
     */
    @Override
    public AuthInfo doAuth(String userId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(super.getLevelUserId(), orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号： ", orderId, " 状态，待一级负责人审批 ", super.getLevelUserName());
        }
        // 下一级审批
        AuthLink next = super.getNext();
        if (null == next) {
            return new AuthInfo("0000", "单号： ", orderId, " 状态，一级负责人审批完成", " 时间：", format.format(date), " 审批人：", super.getLevelUserName());
        }
        // 审批完成
        if (authDate.after(beginDate) && authDate.before(endDate)) {
            return new AuthInfo("0000", "单号： ", orderId, " 状态，一级负责人审批完成", " 时间：", format.format(date), " 审批人：", super.getLevelUserName());
        }
        return next.doAuth(userId, orderId, authDate);
    }
}
