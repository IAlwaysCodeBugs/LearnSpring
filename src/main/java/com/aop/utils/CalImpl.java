package com.aop.utils;

import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal {

    public int add(int num1, int num2) {
//        System.out.println("add方法的参数是["+num1+"，"+num2+"]");
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
//        System.out.println("sub方法的参数是["+num1+"，"+num2+"]");
        return num1 - num2;

    }

    public int mul(int num1, int num2) {
//        System.out.println("mul方法的参数是["+num1+"，"+num2+"]");

        return num1 * num2;

    }

    public int div(int num1, int num2) {
//        System.out.println("div方法的参数是["+num1+"，"+num2+"]");

        return num1 / num2;

    }
}
