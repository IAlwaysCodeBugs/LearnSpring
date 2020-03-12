package com.ioc.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private long id;
    private String name;
    int age;
    List<Address> addresses;
    public User (){
        System.out.println("创建了User对象");
    }
}
