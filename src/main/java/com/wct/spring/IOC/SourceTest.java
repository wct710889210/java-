package com.wct.spring.IOC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SourceTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for(String string:context.getBeanDefinitionNames()){
            System.out.println(string);
        }
    }
}
