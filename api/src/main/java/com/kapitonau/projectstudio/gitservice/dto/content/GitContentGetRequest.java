package com.kapitonau.projectstudio.gitservice.dto.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitContentGetRequest {

    private Long projectId;
    private String path;
    private String branch;

}
