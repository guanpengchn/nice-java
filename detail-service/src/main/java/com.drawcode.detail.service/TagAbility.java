package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;

public class TagAbility extends BaseAbility {

    @Override
    public void init() {
        data = "TagAbility:";
        try {
            Thread.sleep(3000);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
