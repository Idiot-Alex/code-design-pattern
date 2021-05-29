package com.hotstrip.code.design.adapter.bad;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.adapter.base.model.Account;

/**
 * @author hotstrip
 * 账户 service
 */
public class AccountService {

    /**
     * 处理业务
     * @param message
     */
    public void onMessage(final String message) {
        Account account = JSON.parseObject(message, Account.class);
        account.getNumber();
        account.getAccountDate();
        // 处理自己的业务
    }
}
