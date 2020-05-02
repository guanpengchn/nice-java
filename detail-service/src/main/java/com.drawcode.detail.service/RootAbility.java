package com.drawcode.detail.service;

public class RootAbility extends BaseAbility {

    @Have
    private TitleAbility titleAbility;

    @Override
    public void init() {
        data = "根节点";
    }
}
