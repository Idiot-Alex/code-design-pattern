package com.hotstrip.code.design.prototype.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author hotstrip
 * 选择题类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceQuestion {
    // 题目名称
    private String name;
    // 选项 ABCD
    private Map<String, String> option;
    private String key;

}
