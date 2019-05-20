package com.wct.spring.AOP.SefRealization.advice;

import java.lang.reflect.Method;

public interface BeforeAdvice extends Advice{
    public void before(Method method,Object[] args);
}
