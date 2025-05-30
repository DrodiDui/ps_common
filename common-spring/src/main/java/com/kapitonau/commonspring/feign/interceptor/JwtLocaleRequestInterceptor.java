package com.kapitonau.commonspring.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class JwtLocaleRequestInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) return;
        HttpServletRequest request = requestAttributes.getRequest();

        String jwtHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (jwtHeader != null) {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, jwtHeader);
        }

        String space = request.getHeader("Space");
        if (space != null) {
            requestTemplate.header("Space", space);
        }
    }


}
