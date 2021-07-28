package com.hotstrip.code.design.chapter17.good.cook.impl;

import com.hotstrip.code.design.chapter17.good.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 江苏厨师实现类，负责烹饪江苏菜肴
 * @author Hotstrip
 */
@Slf4j
public class JiangSuCook implements ICook {
    @Override
    public void doCooking() {
        log.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受欢迎的菜系之一。");
    }
}
