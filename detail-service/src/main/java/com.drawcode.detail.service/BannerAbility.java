package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class BannerAbility extends BaseAbility {

    @Override
    public void init() {
        data = "BannerAbility";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
