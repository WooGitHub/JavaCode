package com.example.testdemo.testdemo.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Woo_home
 * @create by 2019/10/22
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<String, Object>();
        map.put("name","lisa");
        map.put("age",18);
        map.put("address","shenzhen");
        System.out.println(map);
        System.out.println(map.get("name"));
        System.out.println(map.size());
    }
}
