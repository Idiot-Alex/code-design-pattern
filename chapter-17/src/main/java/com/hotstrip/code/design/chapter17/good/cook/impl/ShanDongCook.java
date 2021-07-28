package com.hotstrip.code.design.chapter17.good.cook.impl;

import com.hotstrip.code.design.chapter17.good.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 山东厨师实现类，负责烹饪山东菜肴
 * @author Hotstrip
 */
@Slf4j
public class ShanDongCook implements ICook {
    @Override
    public void doCooking() {
        log.info("山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味最为龙头。");
    }
}
