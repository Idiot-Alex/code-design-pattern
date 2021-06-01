package com.hotstrip.code.design.good.model;

import com.hotstrip.code.design.good.model.vo.TreeNode;
import com.hotstrip.code.design.good.model.vo.TreeRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author hotstrip
 * 规则树聚合
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeRich {

    // 树根信息
    private TreeRoot treeRoot;
    // 树节点信息
    private Map<Long, TreeNode> treeNodeMap;
}
