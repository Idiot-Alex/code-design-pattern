package com.hotstrip.code.design.good.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author hotstrip
 * 规则树节点信息
 */
@Data
public class TreeNode {

    // 规则树 ID
    private Long treeId;
    // 规则树节点 ID
    private Long treeNodeId;
    // 节点类型 1：子叶 2：果实
    private Integer nodeType;
    // 节点值 [nodeType == 2] 果实值
    private String nodeValue;
    // 规则 key
    private String ruleKey;
    // 规则描述
    private String ruleDesc;
    // 节点链路
    private List<TreeNodeLink> treeNodeLinkList;
}
