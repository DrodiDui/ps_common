package com.kapitonau.projectstudio.taskservice.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskPostRequest {

    private String title;
    private String description;
    private String taskStatus;
    private String taskPriority;
    private String taskType;
    private Long projectId;
    private LocalDate startDate;
    private LocalDate dueDate;
    private Long assigneeId;

}
