package com.ioc.test;

import com.ioc.entity.Car;
import com.ioc.factory.InstanceCarFactory;
import com.ioc.factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        Car car = StaticCarFactory.getCar(1L);
        System.out.println(car);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car1 = (Car) applicationContext.getBean("car");
        System.out.println(car1);


        InstanceCarFactory instanceCarFactory =  new InstanceCarFactory();
        Car car2 =instanceCarFactory.getCar(1L);
        System.out.println(car2);

        Car car3 = (Car) applicationContext.getBean("car2");
        System.out.println(car3);

    }
}
