package com.kapitonau.projectstudio.gitservice.dto;

import com.kapitonau.projectstudio.projectservice.dto.employee.EmployeeResponse;
import com.kapitonau.projectstudio.projectservice.dto.project.ProjectResponse;
import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepositoryResponse {

    private Long repositoryId;
    private String name;
    private ProjectResponse project;
    private EmployeeResponse owner;
    private ZonedDateTime lastModifiedTime;
    private EmployeeResponse lastModifiedBy;
    private ReferenceItemResponse gitProvider;

}
