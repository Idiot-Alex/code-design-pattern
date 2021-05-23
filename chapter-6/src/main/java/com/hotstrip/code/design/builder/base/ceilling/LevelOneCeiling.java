package com.hotstrip.code.design.builder.base.ceilling;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 一级吊顶
 */
public class LevelOneCeiling implements Matter {
    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司自带";
    }

    @Override
    public String model() {
        return "一级顶";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(260);
    }

    @Override
    public String desc() {
        return "造型只做低一级，只有一个层次的吊顶，一般离顶 120-150mm";
    }
}
