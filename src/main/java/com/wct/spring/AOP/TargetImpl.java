package com.wct.spring.AOP;

public class TargetImpl implements Target{
    @Override
    public void request() {
        System.out.println("request");
    }

    @Override
    public void info() {
        System.out.println("info");
    }
}
