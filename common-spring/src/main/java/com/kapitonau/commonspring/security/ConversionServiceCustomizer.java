package com.kapitonau.commonspring.security;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.security.config.crypto.RsaKeyConversionServicePostProcessor;


public class ConversionServiceCustomizer implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.getBean(RsaKeyConversionServicePostProcessor.class);
    }
}
