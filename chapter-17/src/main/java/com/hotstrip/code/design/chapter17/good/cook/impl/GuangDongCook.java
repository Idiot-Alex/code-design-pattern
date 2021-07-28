package com.hotstrip.code.design.chapter17.good.cook.impl;

import com.hotstrip.code.design.chapter17.good.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 广东厨师实现类，负责烹饪广东菜肴
 * @author Hotstrip
 */
@Slf4j
public class GuangDongCook implements ICook {
    @Override
    public void doCooking() {
        log.info("广东厨师，烹饪粤菜，国内民间第二大菜系，国外最有影响力的中国菜系之一。");
    }
}
