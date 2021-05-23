package com.hotstrip.code.design.builder.base.ceilling;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 二级吊顶
 */
public class LevelTwoCeiling implements Matter {
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
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶的高度一般往下吊 20cm，如果层很高，则可以增加每级的厚度";
    }
}
