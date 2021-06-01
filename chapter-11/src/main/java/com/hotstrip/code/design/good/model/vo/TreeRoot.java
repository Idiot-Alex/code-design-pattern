package com.hotstrip.code.design.good.model.vo;

import lombok.Data;

/**
 * @author hotstrip
 * 树根信息
 */
@Data
public class TreeRoot {

    // 规则树 ID
    private Long treeId;
    // 规则树根 ID
    private Long treeRootNodeId;
    // 规则树名称
    private String treeName;
}
