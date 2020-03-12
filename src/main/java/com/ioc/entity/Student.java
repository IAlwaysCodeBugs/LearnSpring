package com.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
  private long id;
  private String name;
  private int age;
  private Car car;
  private List<Address> addresses;

  public Student (){
    System.out.println("创建了Student对象");
  }

  }

