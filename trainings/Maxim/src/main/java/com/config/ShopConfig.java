package com.config;

import com.zooshop.Dialogue;
import com.zooshop.ShopService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ShopConfig {

    @Bean
    static ShopService getService(){
        return new ShopService();
    }

    @Bean
    static Dialogue getDialogue(){
        return new Dialogue();
    }

}
