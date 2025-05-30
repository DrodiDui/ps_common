package com.kapitonau.projectstudio.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddUserToSpaceEventDto {

    private Long userId;
    private Long spaceId;
    private Long spaceRoleId;

}
