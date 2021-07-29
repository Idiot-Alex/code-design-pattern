package com.hotstrip.code.design.chapter18.group;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 树节点链路
 * @author Hotstrip
 */
@NoArgsConstructor
@Data
public class Link {
    // 雇员 ID
    private String fromId;
    // 雇员 ID
    private String toId;
}
