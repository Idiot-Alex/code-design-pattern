package com.hotstrip.code.design.chapter14.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品活动库存实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    // 库存总量
    private int total;
    // 库存已用
    private int used;
}
