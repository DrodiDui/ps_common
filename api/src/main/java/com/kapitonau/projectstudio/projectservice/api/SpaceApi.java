package com.kapitonau.projectstudio.projectservice.api;

import com.kapitonau.projectstudio.projectservice.dto.employee.EmployeeResponse;
import com.kapitonau.projectstudio.projectservice.dto.space.SpaceEmployeePostRequest;
import com.kapitonau.projectstudio.projectservice.dto.space.SpacePostRequest;
import com.kapitonau.projectstudio.projectservice.dto.space.SpaceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SpaceApi {

    @GetMapping("/spaces")
    List<SpaceResponse> getAllSpaces();

    @PostMapping("/spaces")
    SpaceResponse createSpace(@RequestBody SpacePostRequest body);

}
