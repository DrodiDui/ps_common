package com.kapitonau.projectstudio.projectservice.api;

import com.kapitonau.projectstudio.projectservice.dto.employee.EmployeeResponse;
import com.kapitonau.projectstudio.projectservice.dto.employee.PageableEmployeeResponse;
import com.kapitonau.projectstudio.projectservice.dto.space.SpaceEmployeePostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeApi {

    @GetMapping("/employees/{spaceId}")
    PageableEmployeeResponse getAllEmployees(
            @PathVariable("spaceId") Long spaceId,
            @RequestParam(name = "offset", defaultValue = "0") Long offset,
            @RequestParam(name = "limit", defaultValue = "0") Long limit
    );


    @GetMapping("/employees/employee/{employeeId}")
    EmployeeResponse getEmployeeById(@PathVariable("employeeId") Long employeeId);
    
    @GetMapping("/employees/{spaceId}/available")
    List<EmployeeResponse> getAvailableEmployees(@PathVariable("spaceId") Long spaceId);

    @PostMapping("/employees/space")
    List<EmployeeResponse> addEmployeeToSpace(@RequestBody SpaceEmployeePostRequest body);

}
