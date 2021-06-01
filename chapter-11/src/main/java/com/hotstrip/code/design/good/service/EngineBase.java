package com.hotstrip.code.design.good.service;

import com.hotstrip.code.design.good.logic.LogicFilter;
import com.hotstrip.code.design.good.model.TreeRich;
import com.hotstrip.code.design.good.model.vo.EngineResult;
import com.hotstrip.code.design.good.model.vo.TreeNode;
import com.hotstrip.code.design.good.model.vo.TreeRoot;
import com.hotstrip.code.design.good.service.IEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author hotstrip
 */
@Slf4j
public abstract class EngineBase extends EngineConfig implements IEngine {

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);


    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根 ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNode = treeNodeMap.get(rootNodeId);
        // 节点类型 1 子叶 2 果实
        while (treeNode.getNodeType().equals(1)) {
            String ruleKey = treeNode.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNode = logicFilter.filter(matterValue, treeNode.getTreeNodeLinkList());
            treeNode = treeNodeMap.get(nextNode);
            log.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}",
                    treeRoot.getTreeName(), userId, treeId, treeNode.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNode;
    }
}
