package com.ioc.ioc;

import com.ioc.entity.Student;

public class Test {
  public static void main(String [] args){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./src/main/resources/spring.xml");
    Student student=(Student)applicationContext.getBean("student");
    System.out.println(student);
  }
}

