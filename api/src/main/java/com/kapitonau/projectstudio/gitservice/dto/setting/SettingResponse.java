package com.kapitonau.projectstudio.gitservice.dto.setting;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingResponse {

    private Long settingId;
    private String settingName;
}
