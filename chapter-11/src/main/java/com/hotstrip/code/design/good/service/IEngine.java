package com.hotstrip.code.design.good.service;

import com.hotstrip.code.design.good.model.TreeRich;
import com.hotstrip.code.design.good.model.vo.EngineResult;

import java.util.Map;

/**
 * @author hotstrip
 * 规则引擎接口
 */
public interface IEngine {

    /**
     * 决策处理接口方法
     * @param treeId
     * @param userId
     * @param treeRich
     * @param decisionMatter
     * @return
     */
    EngineResult process(final Long treeId, final String userId, final TreeRich treeRich, final Map<String, String> decisionMatter);
}
