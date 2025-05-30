package com.kapitonau.projectstudio.taskservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskStatusPutRequest {

    private String statusCode;

}
