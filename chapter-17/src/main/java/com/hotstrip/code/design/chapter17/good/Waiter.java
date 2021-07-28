package com.hotstrip.code.design.chapter17.good;

import com.hotstrip.code.design.chapter17.good.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟服务生的类
 * @author Hotstrip
 */
public class Waiter {

    private List<ICuisine> cuisineList = new ArrayList<>();

    /**
     * 模拟点单，只需指定是什么菜肴
     * @param cuisine
     */
    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    /**
     * 展示菜单
     */
    public synchronized void placeOrder() {
        cuisineList.stream().forEach(cuisine -> cuisine.cook());

        cuisineList.clear();
    }

}
