package com.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Aspect注解使其变成切面对象

// Component注解使IoC来管理该类，
// 相当于在spring xml文件中配置了一个LoggerAspect的bean
@Aspect
@Component
public class LoggerAspect {
  // 下面这类方法和MyInvocationHandler效果一样，但是实现起来更加方便
  // 注解的作用：
  // 可以将切面对象和业务关联起来
  @Before("execution(public int com.aop.utils.CalImpl.*(..))")
  public void before(JoinPoint joinPoint) {
    // 获取方法名
    String name = joinPoint.getSignature().getName();
    // 获取参数
    String args = Arrays.toString(joinPoint.getArgs());
    System.out.println(name + "方法的参数是：" + args);

  }

  @After("execution(public int com.aop.utils.CalImpl.*(..))")
  public void after(JoinPoint joinPoint){
    // 获取方法名
    String name = joinPoint.getSignature().getName();
    System.out.println(name + "方法执行完毕");
  }

  @AfterReturning(value = "execution(public int com.aop.utils.CalImpl.*(..))",returning = "result")
  public void afterReturning(JoinPoint joinPoint,Object result){
    // 获取方法名
    String name = joinPoint.getSignature().getName();
      System.out.println(name + "方法的结果是："+result);
  }

  @AfterThrowing(value = "execution(public int com.aop.utils.CalImpl.*(..))",throwing = "exception")
  public void afterThrowing(JoinPoint joinPoint,Exception exception){
    String name = joinPoint.getSignature().getName();
    System.out.println(name + "方法有异常："+exception);
  }
}
