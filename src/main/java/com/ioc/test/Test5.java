package com.ioc.test;

import com.ioc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        Student student= (Student) applicationContext.getBean("student");
        System.out.println(student);
        Student student2= (Student) applicationContext.getBean("student2");
        System.out.println(student);

    }
}
