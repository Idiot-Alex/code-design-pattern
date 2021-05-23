package com.hotstrip.code.design.builder.base.floor;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 圣象地板
 */
public class ShengXiangFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "圣象";
    }

    @Override
    public String model() {
        return "一级";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(318);
    }

    @Override
    public String desc() {
        return "圣象地板是中国地板行业著名品牌，拥有中国驰名商品、中国名牌、中国免检、中国环境标志认证等多项荣誉。";
    }
}
