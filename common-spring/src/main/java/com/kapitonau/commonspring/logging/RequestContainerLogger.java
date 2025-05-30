package com.kapitonau.commonspring.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@Component
public class RequestContainerLogger extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
        try {
            logRequest(wrappedRequest);
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            logResponse(wrappedResponse);
        }
        wrappedResponse.copyBodyToResponse();

    }

    private void logResponse(ContentCachingResponseWrapper wrappedResponse) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("==============================START CONTAINER RESPONSE==============================").append("\n");;
        wrappedResponse.getHeaderNames().forEach(headerName -> {
            builder.append(headerName).append(" : ").append(wrappedResponse.getHeader(headerName)).append("\n");;
        });
        if (wrappedResponse.getContentSize() > 0) {
            Charset responseCharset = Optional.ofNullable(wrappedResponse.getCharacterEncoding())
                    .map(Charset::forName)
                    .orElse(StandardCharsets.UTF_8);
            String responseBody = new String(
                    wrappedResponse.getContentAsByteArray(),
                    responseCharset
            );
            builder.append("==============================RESPONSE BODY==============================").append("\n");;
            builder.append(responseBody).append("\n");
        }
        builder.append("===============================END CONTAINER RESPONSE===============================").append("\n");;
        log.info(builder.toString());
    }

    private void logRequest(ContentCachingRequestWrapper wrappedRequest) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("==============================START CONTAINER REQUEST==============================").append("\n");;
        builder.append(wrappedRequest.getMethod()).append(" : ").append(wrappedRequest.getRequestURI()).append("\n");;
        wrappedRequest.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            builder.append(headerName).append(" : ").append(wrappedRequest.getHeader(headerName)).append("\n");
        });
        if (wrappedRequest.getContentLength() > 0) {
            builder.append("==============================REQUEST BODY==============================").append("\n");;
            builder.append(wrappedRequest.getContentAsString()).append("\n");;
        }
        builder.append("===============================END CONTAINER REQUEST===============================").append("\n");;
        log.info(builder.toString());
    }
}













