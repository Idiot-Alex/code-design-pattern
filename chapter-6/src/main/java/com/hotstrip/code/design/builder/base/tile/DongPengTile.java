package com.hotstrip.code.design.builder.base.tile;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 东鹏地砖
 */
public class DongPengTile implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "东鹏瓷砖";
    }

    @Override
    public String model() {
        return "10001";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(102);
    }

    @Override
    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014 年品牌价值 132.35 亿元，位列建陶行业榜首。";
    }
}
