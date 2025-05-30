package com.kapitonau.projectstudio.gitservice.dto.commit;

import com.kapitonau.projectstudio.projectservice.dto.employee.EmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommitResponse {

    private Long commitId;
    private String commit;
    private String message;
    private ZonedDateTime commitTime;
    private EmployeeResponse commitAuthor;


}
