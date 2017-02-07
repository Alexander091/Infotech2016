package com.config;

import com.DAO.DAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ZooConfig.class)
public class DaoConfig {

    @Bean
    DAO getDAO(){
        return new DAO();
    }
}
