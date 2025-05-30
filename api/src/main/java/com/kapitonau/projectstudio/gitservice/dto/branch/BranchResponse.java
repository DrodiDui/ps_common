package com.kapitonau.projectstudio.gitservice.dto.branch;

import com.kapitonau.projectstudio.gitservice.dto.RepositoryResponse;
import com.kapitonau.projectstudio.projectservice.dto.employee.EmployeeResponse;
import com.kapitonau.projectstudio.projectservice.dto.project.ProjectResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchResponse {

    private Long branchId;
    private String branchName;
    /*private RepositoryResponse repository;*/
    private Long branchVersion;

    private ZonedDateTime createdTime;
    private ZonedDateTime modifiedTime;

    private EmployeeResponse lastModifiedBy;

}
