package com.drawcode.detail.service;

public class PriceAbility extends BaseAbility {

    @Have
    private BannerAbility bannerAbility;

    @Have
    private TagAbility tagAbility;

    @Override
    public void init() {
        data = "价格";
    }
}


