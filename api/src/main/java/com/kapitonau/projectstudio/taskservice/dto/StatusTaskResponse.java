package com.kapitonau.projectstudio.taskservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusTaskResponse {

    private String status;
    private List<TaskResponse> tasks;

}
