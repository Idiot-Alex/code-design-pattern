package com.hotstrip.code.design.good.service.impl;

import com.hotstrip.code.design.good.model.TreeRich;
import com.hotstrip.code.design.good.model.vo.EngineResult;
import com.hotstrip.code.design.good.model.vo.TreeNode;
import com.hotstrip.code.design.good.service.EngineBase;

import java.util.Map;

/**
 * @author hotstrip
 * 决策流程处理
 */
public class TreeEngineHandle extends EngineBase {


    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(true, userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
