package com.aop.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
  // 接受委托对象
  private Object object = null;

  // 返回代理对象
  public Object bind(Object object) {
    this.object = object;
    return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
  }


  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(method.getName() + "方法的参数是：" + Arrays.toString(args));

    // 通过反射机制调用委托对象的方法
    // 让委托对象object去调用
    Object result = method.invoke(this.object, args);

    System.out.println(method.getName() + "的结果是" + result);
    return result;
  }
}