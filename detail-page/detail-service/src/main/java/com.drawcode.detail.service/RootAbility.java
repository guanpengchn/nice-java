package com.drawcode.detail.service;

import com.drawcode.detail.service.annoation.Have;
import com.drawcode.detail.service.base.BaseAbility;

public class RootAbility extends BaseAbility {

    @Have
    private TitleAbility titleAbility;

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + "enter");
        data = "RootAbility" + "{" + titleAbility.getData() + "}";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}
