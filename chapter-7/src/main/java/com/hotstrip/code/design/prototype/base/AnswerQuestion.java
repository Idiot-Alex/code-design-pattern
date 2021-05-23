package com.hotstrip.code.design.prototype.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hotstrip
 * 问答题类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerQuestion {
    // 题目
    private String name;
    // 答案
    private String key;
}
