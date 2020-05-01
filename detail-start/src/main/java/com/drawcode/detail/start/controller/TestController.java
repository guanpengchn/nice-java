package com.drawcode.detail.start.controller;

import com.drawcode.detail.client.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public void test() {
        Test test = new Test();
        System.out.println("1234");
    }
}
