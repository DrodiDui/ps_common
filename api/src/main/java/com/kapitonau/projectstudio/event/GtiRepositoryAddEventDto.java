package com.kapitonau.projectstudio.event;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GtiRepositoryAddEventDto {

    private Long projectId;
    private String repositoryName;
    private Long ownerId;
    private Long spaceId;

    private ZonedDateTime messageTime;

    private String gitProviderCode;

}
