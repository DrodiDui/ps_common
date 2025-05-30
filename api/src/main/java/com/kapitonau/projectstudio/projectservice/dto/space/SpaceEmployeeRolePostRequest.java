package com.kapitonau.projectstudio.projectservice.dto.space;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceEmployeeRolePostRequest {

    private Long employeeId;
    private Long spaceEmployeeRoleId;

}
