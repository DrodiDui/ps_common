package com.kapitonau.projectstudio.gitservice.api;

import com.kapitonau.projectstudio.gitservice.dto.branch.BranchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BranchApi {

    @GetMapping("/branches/{repositoryId}")
    List<BranchResponse> getRepositoryBranches(@PathVariable(name = "repositoryId") Long repositoryId);

}
