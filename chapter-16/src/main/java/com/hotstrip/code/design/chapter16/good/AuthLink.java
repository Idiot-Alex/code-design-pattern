package com.hotstrip.code.design.chapter16.good;

import com.hotstrip.code.design.chapter16.base.AuthInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 审批流程的抽象类
 * @author Hotstrip
 */
public abstract class AuthLink {

    protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 审批人信息
     */
    private String levelUserId;
    private String levelUserName;
    /**
     * 责任链模式，下一个节点
     */
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public String getLevelUserId() {
        return levelUserId;
    }

    public String getLevelUserName() {
        return levelUserName;
    }

    public AuthLink getNext() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    /**
     * 审批流程，子类自己实现
     * @param userId
     * @param orderId
     * @param authDate
     * @return
     */
    public abstract AuthInfo doAuth(String userId, String orderId, Date authDate);
}
