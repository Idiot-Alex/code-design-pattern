package com.hotstrip.code.design.builder.good;

import com.hotstrip.code.design.builder.base.ceilling.LevelOneCeiling;
import com.hotstrip.code.design.builder.base.ceilling.LevelTwoCeiling;
import com.hotstrip.code.design.builder.base.coat.DuluxCoat;
import com.hotstrip.code.design.builder.base.coat.LiBangCoat;
import com.hotstrip.code.design.builder.base.floor.ShengXiangFloor;
import com.hotstrip.code.design.builder.base.tile.DongPengTile;
import com.hotstrip.code.design.builder.base.tile.MarcoPoloTile;
import com.hotstrip.code.design.builder.good.menu.DecorationPackageMenu;
import com.hotstrip.code.design.builder.good.menu.IMenu;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 建造者类
 */
public class Builder {

    /**
     * 一级装修风格
     * @param area
     * @return
     */
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(BigDecimal.valueOf(area), "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())
                .appendCeiling(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }

    /**
     * 二级装修风格
     * @param area
     * @return
     */
    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(BigDecimal.valueOf(area), "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())
                .appendCeiling(new LiBangCoat())
                .appendTile(new MarcoPoloTile());
    }

    /**
     * 二级装修风格
     * @param area
     * @return
     */
    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(BigDecimal.valueOf(area), "现代简约")
                .appendCeiling(new LevelOneCeiling())
                .appendCeiling(new LiBangCoat())
                .appendTile(new DongPengTile());
    }
}
