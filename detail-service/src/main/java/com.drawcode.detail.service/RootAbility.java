package com.drawcode.detail.service;

public class RootAbility extends BaseAbility {

    @Have
    private TitleAbility titleAbility;

    @Override
    public void init() {
        try {
            Thread.sleep(1000);// 主线程每隔1秒钟，打印当前时钟时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data = "根节点";
    }
}
