package com.hotstrip.code.design.good.service;

import com.hotstrip.code.design.good.logic.LogicFilter;
import com.hotstrip.code.design.good.logic.impl.UserAgeFilter;
import com.hotstrip.code.design.good.logic.impl.UserGenderFilter;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hotstrip
 * 决策配置类
 */
@Data
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }
}
