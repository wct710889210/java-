package com.wct.spring.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.*;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Target proxy = (Target) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Target.class},
                new RequestCtlInvocationHandler(new TargetImpl()));
        proxy.request();
        proxy.info();
    }
}
