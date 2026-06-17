package com.springmastery.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService(){
        return new PaymentService();
    }
}
