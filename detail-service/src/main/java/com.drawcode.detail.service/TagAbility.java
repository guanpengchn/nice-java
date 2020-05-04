package com.drawcode.detail.service;

import com.drawcode.detail.service.base.BaseAbility;
import com.drawcode.detail.service.netty.HelloService;
import com.drawcode.detail.service.netty.NettyClient;

public class TagAbility extends BaseAbility {

    public static final String providerName = "HelloService#hello#";

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + "enter");
        data = "TagAbility";

        NettyClient consumer = new NettyClient();
        // 创建一个代理对象
        HelloService service = (HelloService) consumer.getBean(HelloService.class, providerName);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.hello("are you ok ?"));
        System.out.println(data);
    }


}
