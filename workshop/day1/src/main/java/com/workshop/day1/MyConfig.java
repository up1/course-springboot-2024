package com.workshop.day1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public GenerateService getGenerateService() {
        return new GenerateService();
    }
}
