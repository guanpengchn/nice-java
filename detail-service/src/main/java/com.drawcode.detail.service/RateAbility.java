package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class RateAbility extends BaseAbility {

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + "enter");
        data = "RateAbility";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}
