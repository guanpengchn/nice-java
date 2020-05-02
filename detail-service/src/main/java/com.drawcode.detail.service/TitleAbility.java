package com.drawcode.detail.service;

public class TitleAbility extends BaseAbility {

    @Have
    private PriceAbility priceAbility;

    @Have
    private TagAbility tagAbility;

    @Override
    public void init() {
        data = "商品标题";
    }
}
