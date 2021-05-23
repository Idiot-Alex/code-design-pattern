package com.hotstrip.code.design.builder.base;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * Matter interface of building
 * 建筑材料接口
 */
public interface Matter {

    /**
     * scene
     * 地板、地砖、涂料、吊顶...
     * @return
     */
    String scene();

    /**
     * brand matter
     * @return
     */
    String brand();

    /**
     * matter model
     * @return
     */
    String model();

    /**
     * price
     * @return
     */
    BigDecimal price();

    /**
     * description
     * @return
     */
    String desc();
}
