package com.wct.spring.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RequestCtlInvocationHandler implements InvocationHandler {
    private Object target;

    public RequestCtlInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("request")){
            System.out.println("AOP前置通知");
        }
        return method.invoke(target,args);
    }
}
