package com.kapitonau.projectstudio.projectservice.dto.employee;

import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private ReferenceItemResponse employeeRole;
    private ReferenceItemResponse employeeStatus;

}
