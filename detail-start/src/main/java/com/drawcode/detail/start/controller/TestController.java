package com.drawcode.detail.start.controller;

import com.drawcode.detail.service.TagAbility;
import com.drawcode.detail.start.util.LoadUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @GetMapping("/")
    public Long test() {
        Date start = new Date();
        LoadUtil.loadAll();
        Date end = new Date();
        long interval = end.getTime() - start.getTime();
        return interval;
    }
}
