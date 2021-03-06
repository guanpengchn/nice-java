package com.drawcode.detail.service;

import com.drawcode.detail.service.annoation.Have;
import com.drawcode.detail.service.base.BaseAbility;

public class PriceAbility extends BaseAbility {

    @Have
    private BannerAbility bannerAbility;

    @Have
    private TagAbility tagAbility;

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + "enter");
        data = "PriceAbility" + "{" + bannerAbility.getData() + tagAbility.getData() + "}";
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}


