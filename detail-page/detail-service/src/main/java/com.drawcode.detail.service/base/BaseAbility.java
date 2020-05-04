package com.drawcode.detail.service.base;

public abstract class BaseAbility {
    protected Object data;
    abstract public void init();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
