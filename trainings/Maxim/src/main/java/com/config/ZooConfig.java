package com.config;

import com.zoo.Cat;
import com.zoo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ZooConfig {

    @Bean
    @Scope("prototype")
    static Cat getCat(){
        return new Cat();
    }

    @Bean
    @Scope("prototype")
    static Dog getDog(){
        return new Dog();
    }
}
