package com.springweb.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @RequestMapping(value = "/test")
    public String test() {

        System.out.println("JSP 실행");

        return "test";
    }
}
