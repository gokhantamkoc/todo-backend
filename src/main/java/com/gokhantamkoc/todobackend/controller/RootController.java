package com.gokhantamkoc.todobackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Value("${version}")
    String version;


    @RequestMapping(value = "/")
    public String index() {
        return "Test System " + version;
    }

    @RequestMapping(value = "/api")
    public String api() {
        return "API " + version;
    }
}
