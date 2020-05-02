package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class SoldAbility extends BaseAbility {

    @Override
    public void init() {
        data = "SoldAbility";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
