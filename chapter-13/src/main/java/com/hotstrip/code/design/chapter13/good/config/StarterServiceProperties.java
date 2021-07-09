package com.hotstrip.code.design.chapter13.good.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
