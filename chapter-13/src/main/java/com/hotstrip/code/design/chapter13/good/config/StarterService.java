package com.hotstrip.code.design.chapter13.good.config;

import org.springframework.util.StringUtils;

/**
 * 白名单配置的实体类，主要是存储从配置文件里面加载的配置结果
 * 方便后续的使用
 */
public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    /**
     * 分割
     * @param separatorChar
     * @return
     */
    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }
}
