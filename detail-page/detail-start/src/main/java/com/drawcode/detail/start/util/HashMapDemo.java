package com.drawcode.detail.start.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<HashConflict, String> map = new HashMap();

        map.put(new HashConflict(), "1");
        map.put(new HashConflict(), "2");
        map.put(new HashConflict(), "3");
        map.put(new HashConflict(), "4");
        map.put(new HashConflict(), "5");
        map.put(new HashConflict(), "6");
        map.put(new HashConflict(), "7");
        map.put(new HashConflict(), "8");
        map.put(new HashConflict(), "9");
        map.put(new HashConflict(), "10");
        map.put(new HashConflict(), "11");
        map.put(new HashConflict(), "12");

        map.put(new HashConflict(), "13");
    }
}



