package com.wct.spring.AOP.SefRealization.pointcut;

public interface Pointcut {
    boolean classMatch(Class<?> clazz);
    boolean methodMath(String methodName);
}
