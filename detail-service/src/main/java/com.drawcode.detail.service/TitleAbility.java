package com.drawcode.detail.service;

import com.drawcode.detail.service.annoation.Have;
import com.drawcode.detail.service.base.BaseAbility;

public class TitleAbility extends BaseAbility {

    @Have
    private PriceAbility priceAbility;

    @Have
    private SoldAbility soldAbility;

    @Have
    private RateAbility rateAbility;

    @Override
    public void init() {
        data = "TitleAbility" + "{" + priceAbility.getData() + soldAbility.getData() + rateAbility.getData() + "}";
        try {
            Thread.sleep(500);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
