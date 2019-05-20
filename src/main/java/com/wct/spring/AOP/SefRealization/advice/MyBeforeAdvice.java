package com.wct.spring.AOP.SefRealization.advice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements BeforeAdvice{
    private String info;

    public MyBeforeAdvice(String info) {
        this.info = info;
    }

    @Override
    public void before(Method method, Object[] args) {
        System.out.println(info);
    }
}
