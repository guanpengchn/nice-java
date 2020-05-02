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
        System.out.println(this.getClass().getName() + "enter");
        data = "TitleAbility" + "{" + priceAbility.getData() + soldAbility.getData() + rateAbility.getData() + "}";
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}
