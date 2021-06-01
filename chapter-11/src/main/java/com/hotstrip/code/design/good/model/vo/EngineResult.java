package com.hotstrip.code.design.good.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hotstrip
 * 决策结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EngineResult {

    // 执行结果
    private boolean isSuccess;
    // 用户 ID
    private String userId;
    // 规则书 ID
    private Long treeId;
    // 果实节点 ID
    private Long nodeId;
    // 果实节点值
    private String nodeValue;

}
