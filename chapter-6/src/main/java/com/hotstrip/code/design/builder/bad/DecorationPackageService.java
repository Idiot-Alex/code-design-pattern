package com.hotstrip.code.design.builder.bad;

import com.hotstrip.code.design.builder.base.Matter;
import com.hotstrip.code.design.builder.base.ceilling.LevelOneCeiling;
import com.hotstrip.code.design.builder.base.ceilling.LevelTwoCeiling;
import com.hotstrip.code.design.builder.base.coat.DuluxCoat;
import com.hotstrip.code.design.builder.base.coat.LiBangCoat;
import com.hotstrip.code.design.builder.base.floor.ShengXiangFloor;
import com.hotstrip.code.design.builder.base.tile.DongPengTile;
import com.hotstrip.code.design.builder.base.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hotstrip
 * 装修包 service
 */
public class DecorationPackageService {

    /**
     * 装修清单
     * @param area
     * @param level
     * @return
     */
    public String getMatterList(BigDecimal area, Integer level) {
        // 装修清单
        List<Matter> list = new ArrayList<>();
        // 装修价格
        BigDecimal price = BigDecimal.ZERO;

        // 豪华欧式：二级吊顶、多乐士涂料、圣象地板
        if (1 == level) {
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            DuluxCoat duluxCoat = new DuluxCoat();
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();
            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);
            price = price.add(area.multiply(BigDecimal.valueOf(0.2)).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(BigDecimal.valueOf(1.4)).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));
        }
        // 轻奢田园：二级吊顶、立邦涂料、马可波罗地板
        if (2 == level) {
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            LiBangCoat liBangCoat = new LiBangCoat();
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();
            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);
            price = price.add(area.multiply(BigDecimal.valueOf(0.2)).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(BigDecimal.valueOf(1.4)).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));
        }
        // 现代简约：一级吊顶、立邦涂料、东鹏地板
        if (3 == level) {
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            LiBangCoat liBangCoat = new LiBangCoat();
            DongPengTile dongPengTile = new DongPengTile();
            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);
            price = price.add(area.multiply(BigDecimal.valueOf(0.2)).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(BigDecimal.valueOf(1.4)).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }
        StringBuilder detail = new StringBuilder("----------------\r\n" +
                "装修清单\r\n" +
                "装修等级：" + level +"\r\n" +
                "装修价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + "元\r\n" +
                "房屋面积：" + area.doubleValue() + "平方米\r\n" +
                "材料清单：\r\n");
        for (Matter matter : list) {
            detail.append(matter.scene()).append("：")
                    .append(matter.brand()).append("、")
                    .append(matter.model()).append("、平方米价格：")
                    .append(matter.price()).append(" 元。\r\n");
        }
        return detail.toString();
    }
}
