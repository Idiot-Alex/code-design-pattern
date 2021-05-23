package com.hotstrip.code.design.builder.base.floor;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 德尔地板
 */
public class DerFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔（Der）";
    }

    @Override
    public String model() {
        return "A+";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(119);
    }

    @Override
    public String desc() {
        return "德尔集团是专业木板制造商，北京 2008 年奥运会家装和公装地板供应商。";
    }
}
