package com.gabo.users.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Gabriel Galvan
 * Date:  08/09/2022
 */
@Configuration
public class FakerBeanConfig {
    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
