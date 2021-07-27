package com.hotstrip.code.design.chapter17.bad;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟服务员角色，从顾客那里记录菜单
 * @author Hotstrip
 */
@Slf4j
public class XiaoEr {

    private Map<Integer, String> cuisineMap = new ConcurrentHashMap<>();

    /**
     * 模拟点单，传入不同菜品类型
     * @param cuisine
     */
    public void order(int cuisine) {
        // 广东菜
        if (1 == cuisine) {
            cuisineMap.put(1, "广东厨师，烹饪粤菜，国内民间第二大菜系，国外最有影响力的中国菜系之一。");
        }
        // 江苏菜
        if (2 == cuisine) {
            cuisineMap.put(2, "江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受欢迎的菜系之一。");
        }
        // 山东菜（鲁菜）
        if (3 == cuisine) {
            cuisineMap.put(3, "山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味最为龙头");
        }
        // 四川菜
        if (4 == cuisine) {
            cuisineMap.put(4, "四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大的菜系之一。");
        }
    }

    /**
     * 展示菜单信息
     */
    public void placeOrder() {
        log.info("菜单：{}", JSON.toJSONString(cuisineMap));
    }

}
