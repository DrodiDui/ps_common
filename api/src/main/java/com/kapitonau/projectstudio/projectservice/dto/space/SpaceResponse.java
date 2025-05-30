package com.kapitonau.projectstudio.projectservice.dto.space;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceResponse {

    private Long spaceId;

    private String title;

    private String description;

}
