package com.kapitonau.commonspring.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kapitonau.commonspring.utils.JsonZonedDateTimeDeserializer;
import com.kapitonau.commonspring.utils.JsonZonedDateTimeSerialize;
import org.springframework.security.access.AccessDeniedException;

import java.time.ZonedDateTime;

public class SpaceAccessDeniedException extends AccessDeniedException {

    private ErrorResponse errorResponse;

    public SpaceAccessDeniedException(String errorCode, String message, ZonedDateTime errorTime) {
        super(message);
        this.errorResponse = new ErrorResponse(errorCode, message, errorTime);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public static class ErrorResponse {
        private final String errorCode;
        private final String message;
        @JsonSerialize(using = JsonZonedDateTimeSerialize.class)
        @JsonDeserialize(using = JsonZonedDateTimeDeserializer.class)
        private final ZonedDateTime errorTime;

        public ErrorResponse(String errorCode, String message, ZonedDateTime errorTime) {
            this.errorCode = errorCode;
            this.message = message;
            this.errorTime = errorTime;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getMessage() {
            return message;
        }

        public ZonedDateTime getErrorTime() {
            return errorTime;
        }
    }
}
