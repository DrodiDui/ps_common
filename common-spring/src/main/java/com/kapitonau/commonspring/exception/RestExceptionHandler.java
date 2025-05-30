package com.kapitonau.commonspring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CommonServiceException.class)
    public ResponseEntity<CommonServiceErrorResponse> handleCommonServiceException(CommonServiceException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body(ex.getErrorResponse());
    }

}
