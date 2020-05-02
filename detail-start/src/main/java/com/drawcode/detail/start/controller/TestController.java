package com.drawcode.detail.start.controller;

import com.drawcode.detail.service.Have;
import com.drawcode.detail.service.RootAbility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        List<Map<String, Class>> resList = new ArrayList<>();
        Class rootClass = RootAbility.class;

        Map<String, Class> rootMap = new HashMap<>();
        rootMap.put(rootClass.getName(), rootClass);
        resList.add(rootMap);

        Queue<Class> classQueue = new LinkedList<>();
        classQueue.add(rootClass);

        while (!classQueue.isEmpty()) {
            Class clazz = classQueue.poll();
            Field[] fields = clazz.getDeclaredFields();

            Map<String, Class> clazzMap = new HashMap<>();

            for (Field field : fields) {
                Have have = field.getAnnotation(Have.class);
                if (have != null) {
                    Class childClass = field.getType();
                    classQueue.add(childClass);
                    clazzMap.put(childClass.getName(), childClass);
                }
            }

            if (!clazzMap.isEmpty()) {
                resList.add(clazzMap);
            }
        }

        Collections.reverse(resList);
        return "1234";
    }
}
