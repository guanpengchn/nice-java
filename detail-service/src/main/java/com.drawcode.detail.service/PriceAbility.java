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
        data = "PriceAbility" + "{" + bannerAbility.getData() + tagAbility.getData() + "}";
        try {
            Thread.sleep(2000);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


