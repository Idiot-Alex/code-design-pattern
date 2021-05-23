package com.hotstrip.code.design.builder.base.coat;

import com.hotstrip.code.design.builder.base.Matter;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 多乐士涂层
 */
public class DuluxCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐士（Dulux）";
    }

    @Override
    public String model() {
        return "第二代";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(719);
    }

    @Override
    public String desc() {
        return "多乐士是阿克苏诺贝尔旗下的著名建筑装饰油漆品牌，" +
                "产品畅销全球 100 多个国家，" +
                "每年全球有 5000 万户家庭使用多乐士油漆";
    }
}
