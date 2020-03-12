package com.aop.Test;

import com.aop.utils.Cal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
  public static void main(String[] args) {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-aop.xml");
    Cal proxy = (Cal) applicationContext.getBean("calImpl");
    proxy.add(1,1);
    proxy.div(2,0);
  }
}
