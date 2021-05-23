package com.hotstrip.code.design.builder.base.tile;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 马克波罗瓷砖
 */
public class MarcoPoloTile implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "马可波罗（MARCO POLO）";
    }

    @Override
    public String model() {
        return "默认";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(140);
    }

    @Override
    public String desc() {
        return "马可波罗品牌诞生于 1996 年，作为国内最早品牌化的建陶品牌，以'文化陶瓷'占领市场，享有'仿古砖至尊'的美誉。";
    }
}
