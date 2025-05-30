package com.kapitonau.commonspring.feign;

import com.kapitonau.commonspring.feign.interceptor.JwtLocaleRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class JwtLocaleFeignConfig {


    @Bean
    JwtLocaleRequestInterceptor jwtLocaleRequestInterceptor() {
        return new JwtLocaleRequestInterceptor();
    }


}
