package com.guanghui.springbootreact.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${app.version}")  // custom property in application.yml
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getApp() {
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }

    @GetMapping
    @RequestMapping("/hi")
    public String hi() {
        return "Hi Derek!";  // modify this, this will auto compiled and don't have to restart the server

    }
}
