package com.drawcode.detail.service;

import com.drawcode.detail.service.annoation.Have;
import com.drawcode.detail.service.base.BaseAbility;

public class RootAbility extends BaseAbility {

    @Have
    private TitleAbility titleAbility;

    @Override
    public void init() {
        data = "RootAbility" + "{" + titleAbility.getData() + "}";
        try {
            Thread.sleep(1000);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
