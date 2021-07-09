package com.hotstrip.code.design.chapter13.good.config;

import org.springframework.util.StringUtils;

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
