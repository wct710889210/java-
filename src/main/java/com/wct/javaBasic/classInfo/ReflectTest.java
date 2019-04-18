package com.wct.javaBasic.classInfo;

import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.wct.jpa.entity.Address");
            for (Method method:c.getMethods()){
                System.out.println(method.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
