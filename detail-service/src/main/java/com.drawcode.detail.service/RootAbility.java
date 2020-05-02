package com.drawcode.detail.service;

import com.drawcode.detail.service.annoation.Have;
import com.drawcode.detail.service.base.BaseAbility;

public class RootAbility extends BaseAbility {

    @Have
    private TitleAbility titleAbility;

    @Override
    public void init() {
        data = "RootAbility" + "{" + titleAbility.getData() + "}";
    }
}
