package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class RateAbility extends BaseAbility {

    @Override
    public void init() {
        data = "RootAbility";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
