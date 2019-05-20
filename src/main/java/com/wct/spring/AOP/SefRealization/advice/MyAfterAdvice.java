package com.wct.spring.AOP.SefRealization.advice;

import com.wct.spring.AOP.SefRealization.advice.AfterAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterAdvice {
    private String info;

    public MyAfterAdvice(String info) {
        this.info = info;
    }

    @Override
    public void after(Method method, Object[] args) {
        System.out.println(info);
    }
}
