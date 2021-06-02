package com.hotstrip.code.design.good;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.good.model.TreeRich;
import com.hotstrip.code.design.good.model.vo.EngineResult;
import com.hotstrip.code.design.good.model.vo.TreeNode;
import com.hotstrip.code.design.good.model.vo.TreeNodeLink;
import com.hotstrip.code.design.good.model.vo.TreeRoot;
import com.hotstrip.code.design.good.service.IEngine;
import com.hotstrip.code.design.good.service.impl.TreeEngineHandle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ApiTest {

    private TreeRich treeRich;

    @Before
    public void before() {
//        // 节点 1
//        TreeNode treeNode1 = new TreeNode();
//        treeNode1.setTreeId(100001L);
//        treeNode1.setTreeNodeId(1L);
//        treeNode1.setNodeType(1);
//        treeNode1.setNodeValue(null);
//        treeNode1.setRuleKey("userGender");
//        treeNode1.setRuleDesc("用户性别[男/女]");
//
//        // 链接 1 -> 11
//        TreeNodeLink treeNodeLink11 = new TreeNodeLink();
//        treeNodeLink11.setNodeIdFrom(1L);
//        treeNodeLink11.setNodeIdTo(11L);
//        treeNodeLink11.setRuleLimitType(1);
//        treeNodeLink11.setRuleLimitValue("man");
//
//        // 链接 1 -> 12
//        TreeNodeLink treeNodeLink12 = new TreeNodeLink();
//        treeNodeLink11.setNodeIdFrom(1L);
//        treeNodeLink11.setNodeIdTo(12L);
//        treeNodeLink11.setRuleLimitType(1);
//        treeNodeLink11.setRuleLimitValue("woman");
//
//        List<TreeNodeLink> treeNodeLinkList1 = new ArrayList<>();
//        treeNodeLinkList1.add(treeNodeLink11);
//        treeNodeLinkList1.add(treeNodeLink12);
//
//        treeNode1.setTreeNodeLinkList(treeNodeLinkList1);
//
//        // ----------------------------------------------
//
//        // 节点 11
//        TreeNode treeNode11 = new TreeNode();
//        treeNode11.setTreeId(100001L);
//        treeNode11.setTreeNodeId(11L);
//        treeNode11.setNodeType(1);
//        treeNode11.setNodeValue(null);
//        treeNode11.setRuleKey("userAge");
//        treeNode11.setRuleDesc("用户年龄");
//
//        // 链接 11 -> 111
//        TreeNodeLink treeNodeLink111 = new TreeNodeLink();
//        treeNodeLink111.setNodeIdFrom(11L);
//        treeNodeLink111.setNodeIdTo(111L);
//        treeNodeLink111.setRuleLimitType(3);
//        treeNodeLink111.setRuleLimitValue("25");
//
//        // 链接 11 -> 112
//        TreeNodeLink treeNodeLink112 = new TreeNodeLink();
//        treeNodeLink112.setNodeIdFrom(1L);
//        treeNodeLink112.setNodeIdTo(112L);
//        treeNodeLink112.setRuleLimitType(5);
//        treeNodeLink112.setRuleLimitValue("25");
//
//        List<TreeNodeLink> treeNodeLinkList11 = new ArrayList<>();
//        treeNodeLinkList11.add(treeNodeLink111);
//        treeNodeLinkList11.add(treeNodeLink112);
//
//        treeNode11.setTreeNodeLinkList(treeNodeLinkList11);
//
//        // ----------------------------------------------
//
//        // 节点 12
//        TreeNode treeNode12 = new TreeNode();
//        treeNode12.setTreeId(100001L);
//        treeNode12.setTreeNodeId(12L);
//        treeNode12.setNodeType(1);
//        treeNode12.setNodeValue(null);
//        treeNode12.setRuleKey("userAge");
//        treeNode12.setRuleDesc("用户年龄");
//
//        // 链接 12 -> 121
//        TreeNodeLink treeNodeLink121 = new TreeNodeLink();
//        treeNodeLink121.setNodeIdFrom(12L);
//        treeNodeLink121.setNodeIdTo(121L);
//        treeNodeLink121.setRuleLimitType(3);
//        treeNodeLink121.setRuleLimitValue("25");
//
//        // 链接 12 -> 122
//        TreeNodeLink treeNodeLink122 = new TreeNodeLink();
//        treeNodeLink122.setNodeIdFrom(12L);
//        treeNodeLink122.setNodeIdTo(122L);
//        treeNodeLink122.setRuleLimitType(5);
//        treeNodeLink122.setRuleLimitValue("25");
//
//        List<TreeNodeLink> treeNodeLinkList12 = new ArrayList<>();
//        treeNodeLinkList12.add(treeNodeLink121);
//        treeNodeLinkList12.add(treeNodeLink122);
//
//        treeNode12.setTreeNodeLinkList(treeNodeLinkList12);
//
//        // ----------------------------------------------
//
//        // 节点：111
//        TreeNode treeNode_111 = new TreeNode();
//        treeNode_111.setTreeId(100001L);
//        treeNode_111.setTreeNodeId(111L);
//        treeNode_111.setNodeType(2);
//        treeNode_111.setNodeValue("果实A");
//
//        // 节点：112
//        TreeNode treeNode_112 = new TreeNode();
//        treeNode_112.setTreeId(100001L);
//        treeNode_112.setTreeNodeId(112L);
//        treeNode_112.setNodeType(2);
//        treeNode_112.setNodeValue("果实B");
//
//        // 节点：121
//        TreeNode treeNode_121 = new TreeNode();
//        treeNode_121.setTreeId(100001L);
//        treeNode_121.setTreeNodeId(121L);
//        treeNode_121.setNodeType(2);
//        treeNode_121.setNodeValue("果实C");
//
//        // 节点：122
//        TreeNode treeNode_122 = new TreeNode();
//        treeNode_122.setTreeId(100001L);
//        treeNode_122.setTreeNodeId(122L);
//        treeNode_122.setNodeType(2);
//        treeNode_122.setNodeValue("果实D");
//
//        // 树根
//        TreeRoot treeRoot = new TreeRoot();
//        treeRoot.setTreeId(100001L);
//        treeRoot.setTreeRootNodeId(1L);
//        treeRoot.setTreeName("规则决策树");
//
//        Map<Long, TreeNode> treeNodeMap = new HashMap<>();
//        treeNodeMap.put(1L, treeNode1);
//        treeNodeMap.put(11L, treeNode11);
//        treeNodeMap.put(12L, treeNode12);
//        treeNodeMap.put(111L, treeNode_111);
//        treeNodeMap.put(112L, treeNode_112);
//        treeNodeMap.put(121L, treeNode_121);
//        treeNodeMap.put(122L, treeNode_122);
//
//        treeRich = new TreeRich(treeRoot, treeNodeMap);

        // 节点：1
        TreeNode treeNode_01 = new TreeNode();
        treeNode_01.setTreeId(10001L);
        treeNode_01.setTreeNodeId(1L);
        treeNode_01.setNodeType(1);
        treeNode_01.setNodeValue(null);
        treeNode_01.setRuleKey("userGender");
        treeNode_01.setRuleDesc("用户性别[男/女]");

        // 链接：1->11
        TreeNodeLink treeNodeLink_11 = new TreeNodeLink();
        treeNodeLink_11.setNodeIdFrom(1L);
        treeNodeLink_11.setNodeIdTo(11L);
        treeNodeLink_11.setRuleLimitType(1);
        treeNodeLink_11.setRuleLimitValue("man");

        // 链接：1->12
        TreeNodeLink treeNodeLink_12 = new TreeNodeLink();
        treeNodeLink_12.setNodeIdFrom(1L);
        treeNodeLink_12.setNodeIdTo(12L);
        treeNodeLink_12.setRuleLimitType(1);
        treeNodeLink_12.setRuleLimitValue("woman");

        List<TreeNodeLink> treeNodeLinkList_1 = new ArrayList<>();
        treeNodeLinkList_1.add(treeNodeLink_11);
        treeNodeLinkList_1.add(treeNodeLink_12);

        treeNode_01.setTreeNodeLinkList(treeNodeLinkList_1);

        // 节点：11
        TreeNode treeNode_11 = new TreeNode();
        treeNode_11.setTreeId(10001L);
        treeNode_11.setTreeNodeId(11L);
        treeNode_11.setNodeType(1);
        treeNode_11.setNodeValue(null);
        treeNode_11.setRuleKey("userAge");
        treeNode_11.setRuleDesc("用户年龄");

        // 链接：11->111
        TreeNodeLink treeNodeLink_111 = new TreeNodeLink();
        treeNodeLink_111.setNodeIdFrom(11L);
        treeNodeLink_111.setNodeIdTo(111L);
        treeNodeLink_111.setRuleLimitType(3);
        treeNodeLink_111.setRuleLimitValue("25");

        // 链接：11->112
        TreeNodeLink treeNodeLink_112 = new TreeNodeLink();
        treeNodeLink_112.setNodeIdFrom(11L);
        treeNodeLink_112.setNodeIdTo(112L);
        treeNodeLink_112.setRuleLimitType(5);
        treeNodeLink_112.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_11 = new ArrayList<>();
        treeNodeLinkList_11.add(treeNodeLink_111);
        treeNodeLinkList_11.add(treeNodeLink_112);

        treeNode_11.setTreeNodeLinkList(treeNodeLinkList_11);

        // 节点：12
        TreeNode treeNode_12 = new TreeNode();
        treeNode_12.setTreeId(10001L);
        treeNode_12.setTreeNodeId(12L);
        treeNode_12.setNodeType(1);
        treeNode_12.setNodeValue(null);
        treeNode_12.setRuleKey("userAge");
        treeNode_12.setRuleDesc("用户年龄");

        // 链接：12->121
        TreeNodeLink treeNodeLink_121 = new TreeNodeLink();
        treeNodeLink_121.setNodeIdFrom(12L);
        treeNodeLink_121.setNodeIdTo(121L);
        treeNodeLink_121.setRuleLimitType(3);
        treeNodeLink_121.setRuleLimitValue("25");

        // 链接：12->122
        TreeNodeLink treeNodeLink_122 = new TreeNodeLink();
        treeNodeLink_122.setNodeIdFrom(12L);
        treeNodeLink_122.setNodeIdTo(122L);
        treeNodeLink_122.setRuleLimitType(5);
        treeNodeLink_122.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_12 = new ArrayList<>();
        treeNodeLinkList_12.add(treeNodeLink_121);
        treeNodeLinkList_12.add(treeNodeLink_122);

        treeNode_12.setTreeNodeLinkList(treeNodeLinkList_12);

        // 节点：111
        TreeNode treeNode_111 = new TreeNode();
        treeNode_111.setTreeId(10001L);
        treeNode_111.setTreeNodeId(111L);
        treeNode_111.setNodeType(2);
        treeNode_111.setNodeValue("果实A");

        // 节点：112
        TreeNode treeNode_112 = new TreeNode();
        treeNode_112.setTreeId(10001L);
        treeNode_112.setTreeNodeId(112L);
        treeNode_112.setNodeType(2);
        treeNode_112.setNodeValue("果实B");

        // 节点：121
        TreeNode treeNode_121 = new TreeNode();
        treeNode_121.setTreeId(10001L);
        treeNode_121.setTreeNodeId(121L);
        treeNode_121.setNodeType(2);
        treeNode_121.setNodeValue("果实C");

        // 节点：122
        TreeNode treeNode_122 = new TreeNode();
        treeNode_122.setTreeId(10001L);
        treeNode_122.setTreeNodeId(122L);
        treeNode_122.setNodeType(2);
        treeNode_122.setNodeValue("果实D");

        // 树根
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(10001L);
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("规则决策树");

        Map<Long, TreeNode> treeNodeMap = new HashMap<>();
        treeNodeMap.put(1L, treeNode_01);
        treeNodeMap.put(11L, treeNode_11);
        treeNodeMap.put(12L, treeNode_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);

        treeRich = new TreeRich(treeRoot, treeNodeMap);
    }

    @Test
    public void test_tree() {
        log.info("决策树组合结构信息：\r\n" + JSON.toJSONString(treeRich));

        IEngine treeEngineHandle = new TreeEngineHandle();

        /**
         * 测试数据
         * 果实A：gender=man、age=22
         * 果实B：gender=man、age=29
         * 果实C：gender=woman、age=22
         * 果实D：gender=woman、age=29
         */
        Map<String, String> decisionMatter = new HashMap<>();
        decisionMatter.put("gender", "man");
        decisionMatter.put("age", "29");

        EngineResult result = treeEngineHandle.process(10001L, "Oli09pLkdjh", treeRich, decisionMatter);
        log.info("测试结果：{}", JSON.toJSONString(result));

    }
}
