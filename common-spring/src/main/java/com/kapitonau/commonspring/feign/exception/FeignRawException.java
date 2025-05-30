package com.kapitonau.commonspring.feign.exception;//package com.lwo.ibankcredoapigateway.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Getter
@Setter
public class FeignRawException extends RuntimeException {

    private final int status;
    private final String body;
    private final Map<String, Collection<String>> headers;

    public FeignRawException(int status, String body, Map<String, Collection<String>> headers) {
        super(body);
        this.status = status;
        this.body = body;
        this.headers = headers;
    }
}
