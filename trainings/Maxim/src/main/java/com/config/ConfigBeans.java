package com.config;

import com.DAO.DAO;
import com.zoo.Cat;
import com.zoo.Dog;
import com.zooshop.Dialogue;
import com.zooshop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigBeans {

    @Bean
    static DAO getDAO(){
        return new DAO();
    }

    @Bean
    static ShopService getService(){
        return new ShopService();
    }

    @Bean
    static Dialogue getDialogue(){
        return new Dialogue();
    }

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
