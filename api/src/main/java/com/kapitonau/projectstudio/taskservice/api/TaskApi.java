package com.kapitonau.projectstudio.taskservice.api;

import com.kapitonau.projectstudio.common.dto.EmptyDto;
import com.kapitonau.projectstudio.taskservice.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskApi {

    @GetMapping("/tasks")
    PageableTaskResponse getTasks(
            @RequestParam(name = "offset", defaultValue = "0") Long offset,
            @RequestParam(name = "limit", defaultValue = "10") Long limit
    );

    @GetMapping("/tasks/statuses")
    List<StatusTaskResponse> getTasksByStatues();


    @GetMapping("/tasks/{taskId}/details")
    TaskResponse getTask(@PathVariable("taskId") Long taskId);

    @PostMapping("/tasks")
    TaskResponse addTask(@RequestBody TaskPostRequest body);

    @PutMapping("/tasks/{taskId}/status")
    TaskResponse updateTask(@PathVariable("taskId") Long taskId, @RequestBody TaskStatusPutRequest body);

    @DeleteMapping("/tasks/{taskId}")
    EmptyDto deleteTask(@PathVariable("taskId") Long taskId);
}
