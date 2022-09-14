package com.mamun25dev.springkafkabasic.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Gson gson(){
        return new Gson();
    }

}
