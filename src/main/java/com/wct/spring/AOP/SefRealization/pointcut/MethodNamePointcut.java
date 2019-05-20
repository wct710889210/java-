package com.wct.spring.AOP.SefRealization.pointcut;

public class MethodNamePointcut implements Pointcut{
    private String requiredName;

    public MethodNamePointcut(String requiredName) {
        this.requiredName = requiredName;
    }

    @Override
    public boolean classMatch(Class<?> clazz) {
        return true;
    }

    @Override
    public boolean methodMath(String methodName) {
        if(methodName.equals(requiredName)){
            return true;
        }
        return false;
    }
}
