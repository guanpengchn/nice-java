package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class BannerAbility extends BaseAbility {

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + "enter");
        data = "BannerAbility";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}
