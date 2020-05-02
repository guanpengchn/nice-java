package com.drawcode.detail.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        // TitleAbility开始扫描
//        Class rootClass = Class.forName()
        return "1234";
    }
}
