package com.ioc.test;

import com.ioc.entity.Student;
import com.ioc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
  public static void main(String [] args){
//    Student student = new Student();
//    student.setId(1L);
//    student.setName("张三");
//    System.out.println(student);
    //加载配置文件
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Student student = (Student) applicationContext.getBean("student");
    System.out.println(student);
    Student stu2 = (Student) applicationContext.getBean("stu2");
    System.out.println(stu2);
    User user = (User) applicationContext.getBean("user");
    System.out.println(user);


  }
}
