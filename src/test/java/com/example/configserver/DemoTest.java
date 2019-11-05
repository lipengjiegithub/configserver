package com.example.configserver;

import org.springframework.boot.configurationprocessor.json.JSONTokener;

public class DemoTest {

    public static void main(String[] args) throws Exception {
        JSONTokener jsonTokener = new JSONTokener("{\"***\": \"name\"}");
        System.out.println(jsonTokener.nextValue());
    }
}
