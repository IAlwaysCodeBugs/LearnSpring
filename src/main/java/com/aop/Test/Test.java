package com.aop.Test;

import com.aop.utils.Cal;
import com.aop.utils.CalImpl;
import com.aop.utils.MyInvocationHandler;

public class Test {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        cal.add(1,1);
        cal.sub(2,1);
        cal.mul(2,3);
        cal.div(6,2);
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler();
        Cal call = (Cal) myInvocationHandler.bind(cal);
        call.add(1,1);
        call.sub(2,1);
        call.mul(2,3);
        call.div(8,2);
    }
}
