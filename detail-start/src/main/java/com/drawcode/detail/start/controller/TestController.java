package com.drawcode.detail.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public void test() {
        System.out.println("1234");
    }
}
