package com.example.configserver.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private String name;
    private List<String> hoppies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHoppies() {
        return hoppies;
    }

    public void setHoppies(List<String> hoppies) {
        this.hoppies = hoppies;
    }
}
