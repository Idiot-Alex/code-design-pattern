package com.hotstrip.code.design.chapter13.base.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hotstrip
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String name;
    private Integer age;
    private String address;
}
