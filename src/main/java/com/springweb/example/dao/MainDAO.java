package com.springweb.example.dao;

import com.springweb.example.dto.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MainDAO {

    public List<Person> peopleList();

}
