package com.kapitonau.projectstudio.gitservice.api;

import com.kapitonau.projectstudio.gitservice.dto.content.GitContentGetRequest;
import com.kapitonau.projectstudio.gitservice.dto.content.GitDirectoryResponse;
import com.kapitonau.projectstudio.gitservice.dto.content.GitFileResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContentApi {

    @PostMapping("/get/contents/directories")
    List<GitDirectoryResponse> getDirectories(@RequestBody GitContentGetRequest body);

    @PostMapping("/get/contents/file")
    GitFileResponse getFile(@RequestBody GitContentGetRequest body);

}
