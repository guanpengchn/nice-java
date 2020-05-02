package com.drawcode.detail.service;

public class TitleAbility extends BaseAbility {

    @Have
    private PriceAbility priceAbility;

    @Have
    private SoldAbility soldAbility;

    @Have
    private RateAbility rateAbility;

    @Override
    public void init() {
        try {
            Thread.sleep(500);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data = "商品标题";
    }
}
