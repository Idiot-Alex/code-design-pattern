package com.hotstrip.code.design.bad;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * 营销场景，违背设计模式代码
 * 根据性别和年龄判断，返回不同的结果
 */
@Slf4j
public class EngineController {

    /**
     * 处理不同用户返回不同结果
     * @param userId
     * @param userSex
     * @param userAge
     * @return
     */
    public String process(final String userId, final String userSex, final int userAge) {
        log.info("if...else 实现方式判断用户结果。userId: {}, userSex: {}, userAge: {}", userId, userSex, userAge);
        // 判断性别 男
        if ("man".equals(userSex)) {
            // 判断年龄
            if (userAge < 25) {
                return "果实 A";
            }
            if (userAge > 25) {
                return "果实 B";
            }
        }
        // 判断性别 女
        if ("woman".equals(userSex)) {
            // 判断年龄
            if (userAge < 25) {
                return "果实 C";
            }
            if (userAge > 25) {
                return "果实 D";
            }
        }
        return null;
    }
}
