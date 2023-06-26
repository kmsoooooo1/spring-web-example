package com.springweb.example.service.impl;

import com.springweb.example.dao.MainDAO;
import com.springweb.example.dto.Person;
import com.springweb.example.service.MainService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainDAO dao;
    @Override
    public int selectPerson() {

        int totSize = 0;

        try{
            totSize = dao.peopleList();
        }catch(Exception e){
            e.printStackTrace();
        }

        return totSize;
    }
}
