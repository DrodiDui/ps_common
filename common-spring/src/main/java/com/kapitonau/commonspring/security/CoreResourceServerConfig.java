package com.kapitonau.commonspring.security;


import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreResourceServerConfig {


    @Bean
    BeanFactoryPostProcessor conversionServiceCustomizer() {
        return new ConversionServiceCustomizer();
    }

}
