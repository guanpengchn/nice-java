package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class RateAbility extends BaseAbility {

    @Override
    public void init() {
        data = "RootAbility";
        try {
            Thread.sleep(2000);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
