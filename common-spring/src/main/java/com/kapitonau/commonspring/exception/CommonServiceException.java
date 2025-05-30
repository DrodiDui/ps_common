package com.kapitonau.commonspring.exception;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class CommonServiceException extends RuntimeException {

    private final Integer statusCode;
    private final CommonServiceErrorResponse errorResponse;

    public CommonServiceException(Integer statusCode, CommonServiceErrorResponse errorResponse) {
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public CommonServiceException(Integer statusCode, String errorCode, String localMessage, ZonedDateTime errorTime) {
        this.statusCode = statusCode;
        this.errorResponse = CommonServiceErrorResponse.builder()
                .errorCode(errorCode)
                .localMessage(localMessage)
                .errorTime(errorTime)
                .build();
    }

    public CommonServiceException(String errorCode, String localMessage) {
        this.statusCode = 400;
        this.errorResponse = CommonServiceErrorResponse.builder()
                .errorCode(errorCode)
                .localMessage(localMessage)
                .errorTime(ZonedDateTime.now())
                .build();
    }

}
