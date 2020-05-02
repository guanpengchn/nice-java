package com.drawcode.detail.start.controller;

import com.drawcode.detail.start.util.LoadUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        LoadUtil.loadAll();
        return "1234";
    }
}
