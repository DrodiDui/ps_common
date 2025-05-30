package com.kapitonau.projectstudio.gitservice.dto.content;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GitFileResponse {

    private String name;
    private String path;
    private String sha;
    private Long size;
    private String type;
    private String content;
    private String encoding;

}
