package com.kapitonau.projectstudio.projectservice.dto.space;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceEmployeePostRequest {

    private Long spaceId;
    private List<SpaceEmployeeRolePostRequest> employees;

}
