package com.hotstrip.code.design.good.logic.impl;

import com.hotstrip.code.design.good.logic.BaseLogic;

import java.util.Map;

/**
 * @author hotstrip
 * 用户年龄过滤决策
 */
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
