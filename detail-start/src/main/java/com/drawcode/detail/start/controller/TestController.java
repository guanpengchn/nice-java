package com.drawcode.detail.start.controller;

import com.drawcode.detail.service.Test1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        Test1 test = new Test1();
        System.out.println("1234");

        return "1234";
    }
}
