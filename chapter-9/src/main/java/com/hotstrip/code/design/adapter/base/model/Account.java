package com.hotstrip.code.design.adapter.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hotstrip
 * 账户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    // 开户编号
    private String number;
    // 开户地址
    private String address;
    // 开户时间
    private Date accountDate;
    // 开户描述
    private String desc;
}
