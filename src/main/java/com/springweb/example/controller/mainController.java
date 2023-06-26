package com.springweb.example.controller;

import com.springweb.example.dao.MainDAO;
import com.springweb.example.dto.Person;
import com.springweb.example.service.MainService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class mainController {

    @Autowired
    MainService service;

    @RequestMapping(value = "/test")
    public String test() {

        System.out.println("JSP 실행");

        List<Person> list = service.selectPerson();

        String name = "";

        for (Person p : list){
            name += p.getFirst_name() + " " + p.getLast_name() + "<br>";
        }

        return name;
    }
}
