package com.kapitonau.commonspring.security;

import com.kapitonau.commonspring.utils.YamlPropertySourceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConditionalOnProperty(value = "core.config.security.security-props.path")
@PropertySource(value = "${core.config.security.security-props.path}", factory = YamlPropertySourceFactory.class, ignoreResourceNotFound = true)
public class PropertiesConfig {
    @Bean
    @ConfigurationProperties(prefix = "security-props")
    public SecurityProps securityProps() {
        return new SecurityProps();
    }
}
