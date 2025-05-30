package com.kapitonau.projectstudio.gitservice.dto.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitDirectoryResponse {

    private String name;
    private String path;
    private String sha;
    private Long size;
    private String type;
}
