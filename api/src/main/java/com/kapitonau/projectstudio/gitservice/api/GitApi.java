package com.kapitonau.projectstudio.gitservice.api;

import com.kapitonau.projectstudio.gitservice.dto.RepositoryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GitApi {

    @GetMapping("/repositories/project/{projectId}")
    RepositoryResponse getRepositoryByProjectId(@PathVariable(name = "projectId") Long projectId);

    @GetMapping("/repositories/{repositoryId}")
    RepositoryResponse getRepository(@PathVariable(name = "repositoryId") Long repositoryId);

    @GetMapping("/repositories")
    List<RepositoryResponse> getRepositories();

}
