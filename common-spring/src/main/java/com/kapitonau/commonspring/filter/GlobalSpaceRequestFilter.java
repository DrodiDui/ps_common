package com.kapitonau.commonspring.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class GlobalSpaceRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        for (String headerName : response.getHeaderNames()) {
            if (headerName.equalsIgnoreCase("Access-Control-Allow-Origin")) {
                response.getHeaderNames().remove(headerName);
            }
        }

        filterChain.doFilter(request, response);
    }
}
