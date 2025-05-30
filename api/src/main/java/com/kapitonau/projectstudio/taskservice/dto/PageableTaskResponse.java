package com.kapitonau.projectstudio.taskservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageableTaskResponse {

    private Long totalCount;
    private List<TaskResponse> tasks;

}
