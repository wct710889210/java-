package com.wct.spring.AOP.SefRealization.advice;

import java.lang.reflect.Method;

public interface AfterAdvice extends Advice{
    public void after(Method method, Object[] args);
}
