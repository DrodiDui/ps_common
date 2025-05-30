package com.kapitonau.projectstudio.projectservice.dto.employee;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageableEmployeeResponse {

    private Long totalCount;
    private List<EmployeeResponse> employees;

}
