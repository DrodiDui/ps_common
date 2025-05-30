package com.kapitonau.projectstudio.projectservice.dto.project;

import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Long projectId;
    private Long spaceId;
    private String title;
    private String description;
    private ReferenceItemResponse projectStatus;
    private LocalDate createdDate;
    private LocalDate expectedCloseDate;
}
