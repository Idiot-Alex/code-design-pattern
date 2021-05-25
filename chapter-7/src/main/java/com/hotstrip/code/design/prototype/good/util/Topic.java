package com.hotstrip.code.design.prototype.good.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author hotstrip
 * 答案和选项
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    // 选项
    private Map<String, String> option;
    // 答案
    private String key;
}
