package com.kapitonau.projectstudio.taskservice.dto;

import com.kapitonau.projectstudio.projectservice.dto.employee.EmployeeResponse;
import com.kapitonau.projectstudio.projectservice.dto.project.ProjectResponse;
import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {

    private Long taskId;

    private String name;
    private String title;
    private String description;

    private ReferenceItemResponse taskStatus;
    private ReferenceItemResponse taskPriority;
    private ReferenceItemResponse taskType;

    private LocalDate startDate;
    private LocalDate dueDate;

    private EmployeeResponse owner;
    private EmployeeResponse assignee;

    private ProjectResponse project;

}
