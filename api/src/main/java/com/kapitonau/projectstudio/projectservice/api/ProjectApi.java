package com.kapitonau.projectstudio.projectservice.api;

import com.kapitonau.projectstudio.projectservice.dto.project.ProjectPostRequest;
import com.kapitonau.projectstudio.projectservice.dto.project.ProjectResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjectApi {

    @GetMapping("/projects")
    List<ProjectResponse> getProjects();

    @GetMapping("/projects/{projectId}")
    ProjectResponse getProject(@PathVariable(name = "projectId") Long projectId);

    @PostMapping("/projects")
    ProjectResponse createProject(@RequestBody ProjectPostRequest body);

}
