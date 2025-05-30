package com.kapitonau.projectstudio.gitservice.dto.commit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatedCommitResponse {

    private ZonedDateTime commitDate;
    private List<CommitResponse> commits;

}
