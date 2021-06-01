package com.hotstrip.code.design.good.model.vo;

import lombok.Data;

/**
 * @author hotstrip
 * 规则树线信息
 */
@Data
public class TreeNodeLink {

    // 节点 from
    private Long nodeIdFrom;
    // 节点 to
    private Long nodeIdTo;
    // 限定类型
    private Integer ruleLimitType;
    // 限定值
    private String ruleLimitValue;
}
