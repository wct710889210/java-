package com.wct.spring.IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean("潘文昕")
    public Person person(){
        return new Person();
    }
}
