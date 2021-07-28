package com.hotstrip.code.design.chapter17.good.cook.impl;

import com.hotstrip.code.design.chapter17.good.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 四川厨师实现类，负责烹饪四川菜肴
 * @author Hotstrip
 */
@Slf4j
public class SiChuanCook implements ICook {
    @Override
    public void doCooking() {
        log.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大的菜系之一。");
    }
}
