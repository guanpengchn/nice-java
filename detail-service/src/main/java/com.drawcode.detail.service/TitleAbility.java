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
        data = "商品标题";
    }
}
