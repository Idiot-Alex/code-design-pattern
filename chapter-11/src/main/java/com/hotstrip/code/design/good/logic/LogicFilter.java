package com.hotstrip.code.design.good.logic;

import com.hotstrip.code.design.good.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @author hotstrip
 * 逻辑过滤器
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue 决策值
     * @param treeNodeLinkList 决策节点
     * @return
     */
    Long filter(final String matterValue, final List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料
     * @return
     */
    String matterValue(final Long treeId, final String userId, final Map<String, String> decisionMatter);
}
