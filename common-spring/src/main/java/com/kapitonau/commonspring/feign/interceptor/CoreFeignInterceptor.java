package com.kapitonau.commonspring.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CoreFeignInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) return;
        HttpServletRequest request = requestAttributes.getRequest();

        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader != null) {
            requestTemplate.header("X-Forwarded-For", xForwardedForHeader);
        }
        String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        if (language != null) {
            requestTemplate.header(HttpHeaders.ACCEPT_LANGUAGE, language);
        }
    }


}
