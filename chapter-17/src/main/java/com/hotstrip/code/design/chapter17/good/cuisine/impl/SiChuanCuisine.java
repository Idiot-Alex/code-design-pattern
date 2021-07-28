package com.hotstrip.code.design.chapter17.good.cuisine.impl;

import com.hotstrip.code.design.chapter17.good.cook.ICook;
import com.hotstrip.code.design.chapter17.good.cuisine.ICuisine;

/**
 * 四川菜肴
 * 利用厨师来烹饪
 * @author Hotstrip
 */
public class SiChuanCuisine implements ICuisine {
    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
