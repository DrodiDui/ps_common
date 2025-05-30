package com.kapitonau.commonspring.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.security.interfaces.RSAPublicKey;

@Slf4j
@EnableWebSecurity
@Configuration
public class GlobalResourceServerConfig {

    private final SecurityProps securityProps;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public GlobalResourceServerConfig(
            SecurityProps securityProps,
            CustomAccessDeniedHandler accessDeniedHandler,
            CustomAuthenticationEntryPoint authenticationEntryPoint
    ) {
        this.securityProps = securityProps;
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Value("${spring.security.oauth2.resourceserver.jwt.public-key-location}")
    private RSAPublicKey publicKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                /*.cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("*");
                    config.addAllowedMethod("*");
                    config.addAllowedHeader("*");
                    return config;
                }))*/
                .oauth2ResourceServer( resource ->
                        resource.jwt(jwt -> jwt.decoder(createJwtDecoder()))
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authenticationEntryPoint)
                )
                .authorizeHttpRequests(authorizeRequests -> {
                    // 1. Разрешить публичные эндпоинты
                    for (SecurityProps.ResourceIgnoreMather resourceIgnoreMather : securityProps.getIgnoring()) {
                        authorizeRequests.requestMatchers(
                                HttpMethod.valueOf(resourceIgnoreMather.getMethod()),
                                resourceIgnoreMather.getPath()
                        ).permitAll();
                    }

                    // 2. Обработать остальные правила
                    for (SecurityProps.SpaceResourceMatcher resourceMatcher : securityProps.getSpaceMatchers()) {
                        authorizeRequests.requestMatchers(
                                HttpMethod.valueOf(resourceMatcher.getMethod()),
                                resourceMatcher.getPath()
                        ).access(new GlobalSpaceAuthorizationManager(resourceMatcher));
                    }

                    for (SecurityProps.ResourceMatcher matcher : securityProps.getMatchers()) {
                        authorizeRequests.requestMatchers(
                                HttpMethod.valueOf(matcher.getMethod()),
                                matcher.getPath()
                        ).access(new GlobalAuthorizationManager(matcher));
                    }

                    // 3. Все остальные запросы требуют аутентификации
                    authorizeRequests.anyRequest().authenticated();
                });

        return http.build();
    }

    @Bean
    public JwtDecoder createJwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }


}
