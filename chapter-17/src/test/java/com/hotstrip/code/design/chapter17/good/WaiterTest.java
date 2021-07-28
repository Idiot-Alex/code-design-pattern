package com.hotstrip.code.design.chapter17.good;

import com.hotstrip.code.design.chapter17.good.cook.impl.GuangDongCook;
import com.hotstrip.code.design.chapter17.good.cook.impl.JiangSuCook;
import com.hotstrip.code.design.chapter17.good.cook.impl.ShanDongCook;
import com.hotstrip.code.design.chapter17.good.cook.impl.SiChuanCook;
import com.hotstrip.code.design.chapter17.good.cuisine.impl.GuangDongCuisine;
import com.hotstrip.code.design.chapter17.good.cuisine.impl.JiangSuCuisine;
import com.hotstrip.code.design.chapter17.good.cuisine.impl.ShanDongCuisine;
import com.hotstrip.code.design.chapter17.good.cuisine.impl.SiChuanCuisine;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class WaiterTest {

    @Test
    public void testWaiter() {
        GuangDongCuisine guangDongCuisine = new GuangDongCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        Waiter waiter = new Waiter();
        waiter.order(guangDongCuisine);
        waiter.order(jiangSuCuisine);
        waiter.order(shanDongCuisine);
        waiter.order(siChuanCuisine);

        waiter.placeOrder();
    }

}