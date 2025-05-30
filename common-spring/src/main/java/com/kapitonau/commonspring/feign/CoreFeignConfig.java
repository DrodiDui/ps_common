package com.kapitonau.commonspring.feign;


import com.kapitonau.commonspring.feign.interceptor.CoreFeignInterceptor;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreFeignConfig {


    @Bean
    FormEncoder feignFormEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new FormEncoder(new SpringEncoder(messageConverters));
    }


    @Bean
    ErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    CoreFeignInterceptor coreFeignInterceptor() {
        return new CoreFeignInterceptor();
    }


}
