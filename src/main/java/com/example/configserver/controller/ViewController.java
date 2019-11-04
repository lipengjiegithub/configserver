package com.example.configserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping
public class ViewController {

    @Autowired
    private ConfigurableApplicationContext context;
    @Autowired
    private RefreshScope scope;
    @Value("name")
    private String name;

    @GetMapping
    public String say() {
        return this.name;
    }

    @GetMapping("refresh")
    public void refresh() {
        Set<String> keys = new HashSet<>();
        keys.add("name");
        Map<String, Object> temp = new HashMap<>();
        temp.put("name", "33333");
        ConfigurableEnvironment environment = this.context.getEnvironment();
        MapPropertySource test = new MapPropertySource("test", temp);

        context.publishEvent(new EnvironmentChangeEvent(this.context, keys));
    }

}
