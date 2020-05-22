package com.znsd.config;

import com.znsd.entry.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean //将当前的对象作为工厂的一个对象被管理
    public User getUser(){
        return new User();
    }

    //...
}
