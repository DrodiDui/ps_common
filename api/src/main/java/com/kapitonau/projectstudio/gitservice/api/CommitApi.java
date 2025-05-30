package com.kapitonau.projectstudio.gitservice.api;

import com.kapitonau.projectstudio.gitservice.dto.commit.CommitResponse;
import com.kapitonau.projectstudio.gitservice.dto.commit.DatedCommitResponse;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommitApi {

    @GetMapping("/commits/{commitId}")
    CommitResponse getCommitById(@PathVariable Long commitId);

    @GetMapping("/commits/branch/{branchId}")
    List<DatedCommitResponse> getBranchCommits(@PathVariable Long branchId);

    @GetMapping("/commits/branch/{branchId}/last")
    CommitResponse getLastBranchCommits(@PathVariable Long branchId);

}
