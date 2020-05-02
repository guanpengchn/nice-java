package com.drawcode.detail.start.controller;

import com.drawcode.detail.service.Have;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        // TitleAbility开始扫描
        try {
            Class rootClass = Class.forName("com.drawcode.detail.service.TitleAbility");
            Field[] fields = rootClass.getFields();
            for(Field field : fields) {
                Have have = field.getAnnotation(Have.class);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "1234";
    }
}
