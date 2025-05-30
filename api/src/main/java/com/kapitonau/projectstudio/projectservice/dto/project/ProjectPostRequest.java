package com.kapitonau.projectstudio.projectservice.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPostRequest {

    private Long spaceId;
    private String title;
    private String description;
    private LocalDate expectedCloseDate;

    private Boolean createGitRepository;
    private String gitProviderCode;

}
