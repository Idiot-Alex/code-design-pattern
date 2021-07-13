package com.hotstrip.code.design.chapter13.good.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自定义的配置类
 * 主要目的是条件注入配置文件里面的 itstack.door 属性，表示是否开启拦截
 * 如果开启了，就使用配置文件里的拦截白名单配置信息 itstack.door.userStr
 */
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {
    @Resource
    private StarterServiceProperties starterServiceProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled", havingValue = "true")
    StarterService starterService() {
        return new StarterService(starterServiceProperties.getUserStr());
    }
}
