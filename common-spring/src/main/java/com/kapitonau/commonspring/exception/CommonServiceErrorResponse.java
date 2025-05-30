package com.kapitonau.commonspring.exception;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonServiceErrorResponse {

    private String errorCode;
    private String localMessage;
    private ZonedDateTime errorTime;

}
